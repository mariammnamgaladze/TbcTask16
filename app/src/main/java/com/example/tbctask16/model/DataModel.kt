package com.example.tbctask16.model

import com.squareup.moshi.Json

data class DataModel(
    val data: List<UserData>,
    val page: Int,
    @Json(name = "per_page")
    val perPage: Int,
    val text: String,
    val url: String,
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int
)
{
    data class UserData(
        val avatar: String,
        val email: String,
        @Json(name = "first_name")
        val firstName: String,
        val id: Int,
        @Json(name = "last_name")
        val lastName: String
    )
}