package com.e444er.multimodule.navigation

import com.e444er.common_utils.Activities
import com.e444er.common_utils.Navigator
import com.e444er.news_presentation.GoToNewsActivity
import com.e444er.search_presentation.GoToSearchActivity

class DefaultNavigator : Navigator.Provider {
    override fun getActivities(activities: Activities): Navigator {
        return when (activities) {
            Activities.NewsActivity -> {
                GoToNewsActivity
            }
            Activities.SearchActivity -> {
                GoToSearchActivity
            }
        }
    }
}