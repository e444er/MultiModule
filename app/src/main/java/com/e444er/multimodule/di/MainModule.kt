package com.e444er.multimodule.di

import androidx.transition.Visibility.Mode
import com.e444er.common_utils.Navigator
import com.e444er.multimodule.navigation.DefaultNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MainModule {


    @Provides
    @Singleton
    fun provideProvider(): Navigator.Provider {
        return DefaultNavigator()
    }
}