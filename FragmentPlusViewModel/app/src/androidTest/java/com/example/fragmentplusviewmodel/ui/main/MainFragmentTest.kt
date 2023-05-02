package com.example.fragmentplusviewmodel.ui.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fragmentplusviewmodel.MainActivity
import com.example.fragmentplusviewmodel.R
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {
    @Rule
    @JvmField
    val mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun espresso() {
        val viewInteraction = Espresso.onView(ViewMatchers.withText("Hello World!"))
        Espresso.onView(ViewMatchers.withId(R.id.message)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        viewInteraction.check(ViewAssertions.matches(ViewMatchers.withId(R.id.message)))
    }

    @Test
    fun onCreate() {
    }

    @Test
    fun onCreateView() {
    }
}