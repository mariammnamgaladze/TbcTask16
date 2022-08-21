package com.example.tbctask16.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object RetrofitObj {

    private const val BASE_URL = "https://reqres.in"
    private val retrofitbuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun state() = retrofitbuilder.create(GetUser::class.java)

    interface GetUser {

        @GET("api/users")
        suspend fun user(@Query("page") page: Int): Response<DataModel>
    }


    class UserRepository {

        suspend fun getInfo(page: Int): DataModel? {
            val response = RetrofitObj.state().user(page)
            return if (response.isSuccessful && response.body() != null)
                response.body()!!
            else null
        }

    }
}
