package com.example.finalproject

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Root
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class MainActivityTest{
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCorrectGuess() {
        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("cat"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.scoreTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 1")))
    }

    @Test
    fun testMultipleGuess() {
        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("cat"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("dog"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("banana"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("variety"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("contain"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("state"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("champion"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("incident"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("swarm"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("sequence"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.scoreTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 10")))
    }

    @Test
    fun testIncorrectGuess() {
        // Enter an incorrect guess in the EditText
        Espresso.onView(ViewMatchers.withId(R.id.guessEditText))
            .perform(ViewActions.typeText("dog"), ViewActions.closeSoftKeyboard())

        // Click the Check button
        Espresso.onView(ViewMatchers.withId(R.id.checkButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.scoreTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score:")))
    }

    @Test
    fun testButtonIsClickable() {
        onView(withId(R.id.checkButton))    // find the button with the ID "checkButton"
            .check(matches(isDisplayed()))      // check that the button is displayed
            .check(matches(isEnabled()))        // check that the button is enabled (clickable)
            .perform(click())                   // perform a click on the button
    }
}