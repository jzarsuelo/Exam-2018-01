package com.jzarsuelo.android.exam201801.data

data class FactResponse(
        val title: String,
        val rows: List<Fact>
)

data class Fact(
        val title: String,
        val description: String,
        val imageHref: String
)