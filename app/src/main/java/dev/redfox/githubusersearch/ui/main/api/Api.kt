package dev.redfox.githubusersearch.ui.main.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {

    @GET("search/users")
    @Headers("Authorization: token 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")
    suspend fun getUsers(
        @Query("q") q: String
    ): Response<GtihubResponse>
}