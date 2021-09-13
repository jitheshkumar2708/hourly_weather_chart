package com.example.weatherapp

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.weather.MainActivity

//To run the task for every hour
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class HourlyService : JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("Service", "Service Start")
        onHandleIntent()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("Stop", "Service Stop")
        return true
    }

    fun onHandleIntent() {
        val mainActivity = MainActivity()
        mainActivity.weatherTask().execute()
    }

}