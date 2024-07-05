package ru.me.testplayertimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.me.testplayertimer.presentation.PlayerViewModel

class PlayerActivity : AppCompatActivity() {

    private val playerViewModel: PlayerViewModel by viewModel()

    private lateinit var playButton: Button
    private lateinit var timerTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        playButton = findViewById(R.id.playButton)
        timerTextView = findViewById(R.id.timerTextView)

        playButton.setOnClickListener {
            playerViewModel.onPlayButtonClicked()
        }

        playerViewModel.observePlayerState().observe(this) {
            playButton.isEnabled = it.isPlayButtonEnabled
            playButton.text = it.buttonText
            timerTextView.text = it.progress
        }
    }

    override fun onPause() {
        super.onPause()
        playerViewModel.onPause()
    }

}