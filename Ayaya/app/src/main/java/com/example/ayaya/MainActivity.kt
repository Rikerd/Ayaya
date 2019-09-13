package com.example.ayaya

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.ayayaVideo)

        val videoPath = "android.resource://com.example.ayaya/" + R.raw.rockets

        val uri = Uri.parse(videoPath)

        videoView.setVideoURI(uri)
        videoView.start()

        /*
        videoView.setOnCompletionListener(MediaPlayer.OnCompletionListener {
            override fun onCompletion() {
                videoView.start()
            }
        })*/
    }
}
