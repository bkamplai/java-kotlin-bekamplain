package com.example.oldschooljava

object Util {
    fun defaultVal(x: Int?, defX: Int? = 0): Int {
        return x ?: (defX ?: 0)
    }
}