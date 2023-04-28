package com.example.oldschoolkotlin

import org.junit.Assert.*

import org.junit.Test
import kotlin.math.abs

class MortgageKtTest {

    @Test
    fun calculateMonthlyPayment() {
        var loanAmount = 240_000.0;
        var loanTerm = 30;
        var interestRate = 7.25;
        var expectedPayment = 1637;

        var resultPayment = com.example.oldschoolkotlin.calculateMonthlyPayment(loanAmount, interestRate, loanTerm);

        assert(abs(expectedPayment-resultPayment) < 1.00)
    }
}