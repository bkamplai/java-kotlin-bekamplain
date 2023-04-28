package com.example.oldschooljava

import java.math.BigDecimal

class BigBank {
    var debts = BigDecimal("1000000000000000000000000000000000000000000000000000000000000000.03")
    var assets = BigDecimal("33.33")
    fun value(): BigDecimal {
        return assets -debts;
    }

    override fun toString(): String {
        return value().toString()
    }
}