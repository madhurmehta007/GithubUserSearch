package dev.redfox.githubusersearch.ui.main.api

import retrofit2.Call
import retrofit2.Response

class Repository {

    suspend fun getUsers(q: String): Response<GtihubResponse> {
        return RetrofitInstance.api.getUsers(q)
    }
 }