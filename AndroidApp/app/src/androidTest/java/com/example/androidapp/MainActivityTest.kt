package com.example.androidapp

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculateButton_shouldUpdateResultTextView() {
        // Find the EditText views and enter values
        onView(withId(R.id.pointsReceivedEditText))
            .perform(typeText("75"))
        onView(withId(R.id.pointsPossibleEditText))
            .perform(typeText("100"))

        // Find the Calculate button and click it
        onView(withId(R.id.calculateButton))
            .perform(click())

        // Check that the Result TextView displays the correct text
        onView(withId(R.id.resultTextView))
            .check(matches(withText("Overall Grade: 75.00% C")))
    }

    @Test
    fun testButtonIsClickable() {
        onView(withId(R.id.calculateButton))    // find the button with the ID "calculateButton"
            .check(matches(isDisplayed()))      // check that the button is displayed
            .check(matches(isEnabled()))        // check that the button is enabled (clickable)
            .perform(click())                   // perform a click on the button
    }
}
