package com.example.androidapp

import org.junit.Assert.*

import org.junit.Test
import kotlin.math.abs

class CalculateOverallGradeKtTest {

    @Test
    fun calculateOverallGrade() {
        var pointsReceived = 179.66;
        var pointsPossible = 789.0;
        var expextedGrade = 22.77;

        var resultGrade = com.example.androidapp.calculateOverallGrade(pointsReceived, pointsPossible)

        assert(abs(expextedGrade-resultGrade) < 1.00);
    }
}