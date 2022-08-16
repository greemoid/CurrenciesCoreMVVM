package com.greemoid.realizationcoremvvm.currencies.data

import com.google.gson.annotations.SerializedName
import com.greemoid.realizationcoremvvm.currencies.domain.CurrenciesDomain

interface CurrenciesCloud {

    fun <T> map(mapper: Mapper<T>): T

    class Empty : CurrenciesCloud {
        override fun <T> map(mapper: Mapper<T>): T =
            mapper.map("none", "none", emptyMap())
    }

    data class Base(
        @SerializedName("base")
        private val baseCurrency: String,
        @SerializedName("date")
        private val date: String,
        @SerializedName("rates")
        private val rates: Map<String, Double>
    ) : CurrenciesCloud {
        override fun <T> map(mapper: Mapper<T>): T =
            mapper.map(baseCurrency, date, rates)
    }

    interface Mapper<T> {
        fun map(base: String, date: String, currencies: Map<String, Double>): T

        class Base : Mapper<CurrenciesDomain> {

            override fun map(
                base: String,
                date: String,
                currencies: Map<String, Double>
            ): CurrenciesDomain {
                val result =
                    currencies.map { Pair(it.key, it.value) }.sortedBy { it.first }.toList()
                return CurrenciesDomain.Base(base, date, result)
            }
        }
    }
}