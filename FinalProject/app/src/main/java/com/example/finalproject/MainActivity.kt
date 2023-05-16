package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.finalproject.databinding.ActivityMainBinding
import pl.droidsonroids.gif.GifImageView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fingerSpelledPhotos: List<Pair<String, Int>> // list of finger spelled photos and their corresponding words
    private val gifImageView: GifImageView get() = binding.gifImageView // image view to display the finger spelled photo
    private val scoreTextView: TextView get() = binding.scoreTextView // text view to display the user's score
    private val guessEditText: EditText get() = binding.guessEditText // edit text for the user to enter their guess
    private val checkButton: Button get() = binding.checkButton // button for the user to check their guess
    private var currentPhotoIndex = 0 // index of the current finger spelled photo being displayed
    private var score = 0 // user's current score

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fingerSpelledPhotos = listOf(
            Pair("cat", R.drawable.cat_fingerspelled),
            Pair("dog", R.drawable.dog_fingerspelled),
            Pair("banana", R.drawable.banana_fingerspelled),
            Pair("variety", R.drawable.variety_fingerspelled),
            Pair("contain", R.drawable.contain_fingerspelled),
            Pair("state", R.drawable.state_fingerspelled),
            Pair("champion", R.drawable.champion_fingerspelled),
            Pair("incident", R.drawable.incident_fingerspelled),
            Pair("swarm", R.drawable.swarm_fingerspelled),
            Pair("sequence", R.drawable.sequence_fingerspelled)
            // add more finger spelled photos and their corresponding words here
        )

        checkButton.setOnClickListener {
            checkGuess()
        }
    }

    private fun displayNextPhoto() {
        val photo = fingerSpelledPhotos[currentPhotoIndex]
        gifImageView.setImageResource(photo.second)
        guessEditText.setText("")
    }

    private fun checkGuess() {
        val guess = guessEditText.text.toString().lowercase()
        val photo = fingerSpelledPhotos[currentPhotoIndex]
        if (guess == photo.first) {
            score++
            scoreTextView.text = "Score: $score"
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrect. The word was ${photo.first}.", Toast.LENGTH_LONG).show()
        }
        currentPhotoIndex = (currentPhotoIndex + 1) % fingerSpelledPhotos.size
        displayNextPhoto()
    }
}
