package de.sociant.testapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class StartUpReceiver: BroadcastReceiver() {

    /**
     * wird zum "Aufwecken" der App benötigt, keine weiteren Aktionen mehr erforderlich
     */
    override fun onReceive(p0: Context?, p1: Intent?) {}
}