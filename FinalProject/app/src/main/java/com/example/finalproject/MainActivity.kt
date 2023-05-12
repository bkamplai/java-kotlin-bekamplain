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
    private lateinit var gifImageView: GifImageView // image view to display the finger spelled photo
    private lateinit var scoreTextView: TextView // text view to display the user's score
    private lateinit var guessEditText: EditText // edit text for the user to enter their guess
    private lateinit var checkButton: Button
    private var currentPhotoIndex = 0 // index of the current finger spelled photo being displayed
    private var score = 0 // user's current score

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fingerSpelledPhotos = listOf(
            Pair("cat", R.drawable.cat_fingerspelled),
            Pair("dog", R.drawable.dog_fingerspelled),
            Pair("banana", R.drawable.banana_fingerspelled)
            // add more finger spelled photos and their corresponding words here
        )

        gifImageView = findViewById(R.id.gifImageView)
        scoreTextView = findViewById(R.id.scoreTextView)
        guessEditText = findViewById(R.id.guessEditText)

        checkButton = findViewById(R.id.checkButton)
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
