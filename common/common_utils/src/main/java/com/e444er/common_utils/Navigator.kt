package com.e444er.common_utils

import android.app.Activity

interface Navigator {

    fun navigate(activity: Activity)

    interface Provider{
        fun getActivities(activities: Activities): Navigator
    }
}