package com.e444er.news_presentation

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import com.e444er.common_utils.Activities
import com.e444er.common_utils.Navigator
import com.e444er.news_presentation.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    @Inject
    lateinit var provider: Navigator.Provider

    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, NewsActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private var _binding: ActivityNewsBinding? = null
    private val binding: ActivityNewsBinding
        get() = _binding!!

    private val newsViewModel: NewsViewModel by viewModels()

    private val newsAdapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newsViewModel.getNewsArticles()

        initView()

        setObservers()
    }

    private fun initView() {
        binding.rvArticles.adapter = newsAdapter
        binding.ivGoToSearch.setOnClickListener {
            provider.getActivities(Activities.SearchActivity).navigate(this)
        }
        binding.toNight.setOnClickListener {
            when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Configuration.UI_MODE_NIGHT_NO ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            newsViewModel.newsArticle.collectLatest {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@NewsActivity, it.error, Toast.LENGTH_LONG).show()
                }
                it.data?.let {
                    binding.progressBar.visibility = View.GONE
                    newsAdapter.setData(it)
                }
            }
        }
    }
}

object GoToNewsActivity : Navigator {
    override fun navigate(activity: Activity) {
        NewsActivity.launchActivity(activity)
    }
}