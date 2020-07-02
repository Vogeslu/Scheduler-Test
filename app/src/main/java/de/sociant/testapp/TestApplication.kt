package de.sociant.testapp

import android.app.Application
import com.evernote.android.job.JobManager

class TestApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        /**
         * Initialisierung des Job-Managers und starten
         * des Schedulers
         */
        JobManager.create(this).addJobCreator(BackgroundJobCreator())
        BackgroundJob.scheduleJob()
    }

}