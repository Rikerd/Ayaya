package com.example.ayaya

import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import android.media.MediaPlayer.OnPreparedListener
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState)

        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.ayayaVideo)

        val videoPath = "android.resource://com.example.ya/" + R.raw.ayaya

        val uri = Uri.parse(videoPath)

        videoView.setVideoURI(uri)
        videoView.start()

        val chronometer = findViewById<Chronometer>(R.id.chronometer)

        chronometer.setBase(SystemClock.elapsedRealtime())
        chronometer.start()

        videoView.setOnPreparedListener(OnPreparedListener { mp -> mp.isLooping = true })
    }
}