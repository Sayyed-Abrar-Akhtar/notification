package com.sayyed.googlemap

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.gms.maps.GoogleMap

class MainActivity : AppCompatActivity() {

    private lateinit var btnNotificationHigh: Button
    private lateinit var btnNotificationLow: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNotificationHigh = findViewById(R.id.btnNotificationHigh)
        btnNotificationLow = findViewById(R.id.btnNotificationLow)

        btnNotificationHigh.setOnClickListener {
            showHighPriorityNotification()
        }

        btnNotificationLow.setOnClickListener {
            showLowPriorityNotification()
        }
    }

    private fun showLowPriorityNotification() {
        val notificationManager = NotificationManagerCompat.from(this)

        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.channel_2)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("Low Priority notification")
            .setContentText("This is my notification body")
            .setColor(Color.BLUE)
            .build()

        notificationManager.notify(1, notification)
    }

    private fun showHighPriorityNotification() {

        val notificationManager = NotificationManagerCompat.from(this)

        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.channel_1)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("High Priority notification")
            .setContentText("This is my notification body")
            .setColor(Color.BLUE)
            .build()

        notificationManager.notify(2, notification)

    }
}