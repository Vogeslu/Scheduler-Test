package de.sociant.testapp

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator
import com.evernote.android.job.JobRequest

class BackgroundJobCreator: JobCreator {

    /**
     * Jobcreator zum Verwalten der einzelnen Jobs
     */
    override fun create(tag: String): Job? = when(tag) {
        BackgroundJob.TAG -> BackgroundJob()
        else -> null
    }

}

class BackgroundJob: Job() {

    companion object {
        const val TAG = "background_job"

        /**
         * Statische Funktion um den Job zu schedulen
         * Minimum für Jobs: 15 Minuten
         */
        fun scheduleJob() = JobRequest.Builder(BackgroundJob.TAG).setPeriodic(15*60*1000).build().schedule()
    }

    /**
     * Da man nur alle 15 Minuten einen Job ausführen kann
     * wäre es sinnvoller, wenn man in dem jeweiligen Job Handler
     * einbaut, die alle X Minuten so und so oft den jeweiligen Task
     * ausführen sollen
     */
    override fun onRunJob(params: Params): Result {

        Handler(Looper.getMainLooper()).post {
            /**
             * Ein Toast(brot) wird helfen
             */
            Toast.makeText(context,"Bin ein Task",Toast.LENGTH_SHORT).show()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            Toast.makeText(context,"Bin ein Task",Toast.LENGTH_SHORT).show()
        },5000)

        return Result.SUCCESS
    }


}