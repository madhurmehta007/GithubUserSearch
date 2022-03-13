package dev.redfox.githubusersearch.ui.main.api

import com.google.gson.annotations.SerializedName

data class GtihubResponse(
    @SerializedName("incomplete_results")
    val incomplete_results: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val total_count: Int
)