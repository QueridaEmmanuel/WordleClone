package com.example.wordleclone


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wordleclone.FourLetterWordList

class MainActivity : AppCompatActivity() {
    private lateinit var targetWord: String
    private var guessCount = 0
    private val maxGuesses = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        val guessInput = findViewById<EditText>(R.id.guessInput)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // Set the initial target word
        targetWord = FourLetterWordList.getRandomFourLetterWord()

        // Set the initial feedback text
        feedbackText.text = getString(R.string.feedback_initial)

        // Submit button functionality
        submitButton.setOnClickListener {
            val guess = guessInput.text.toString().uppercase()
            if (guess.length == 4) {
                feedbackText.text = checkGuess(guess)
                guessCount++

                if (feedbackText.text == "OOOO") { // "OOOO" indicates a correct guess
                    feedbackText.text = getString(R.string.congratulations)
                    submitButton.isEnabled = false
                    resetButton.visibility = Button.VISIBLE
                } else if (guessCount >= maxGuesses) {
                    feedbackText.text = getString(R.string.game_over, targetWord)
                    submitButton.isEnabled = false
                    resetButton.visibility = Button.VISIBLE
                }
            } else {
                Toast.makeText(this, getString(R.string.enter_4_letter_word), Toast.LENGTH_SHORT).show()
            }
        }

        // Reset button functionality
        resetButton.setOnClickListener {
            resetGame(guessInput, feedbackText, submitButton, resetButton)
        }
    }

    private fun checkGuess(guess: String): String {
        val result = StringBuilder()
        for (i in guess.indices) {
            result.append(
                when {
                    guess[i] == targetWord[i] -> "O" // Right letter, right position
                    guess[i] in targetWord -> "+"    // Right letter, wrong position
                    else -> "X"                     // Wrong letter
                }
            )
        }
        return result.toString()
    }

    private fun resetGame(
        guessInput: EditText,
        feedbackText: TextView,
        submitButton: Button,
        resetButton: Button
    ) {
        // Generate a new word and reset variables
        targetWord = FourLetterWordList.getRandomFourLetterWord()
        guessCount = 0
        feedbackText.text = getString(R.string.feedback_initial)
        guessInput.text.clear()

        // Reset button states
        submitButton.isEnabled = true
        resetButton.visibility = Button.GONE
    }
}
