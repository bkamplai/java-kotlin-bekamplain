package com.example.androidapp

fun calculateOverallGrade(pointsReceived: Double, pointsPossible: Double): Double {
    return pointsReceived / pointsPossible * 100
}