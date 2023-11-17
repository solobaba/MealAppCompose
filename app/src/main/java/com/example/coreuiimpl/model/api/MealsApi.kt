package com.example.coreuiimpl.model.api

import android.util.Log
import com.example.coreuiimpl.model.response.MealsCategoriesResponse
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealsWebService {

    private var api: MealsApi
    private val interceptor: Interceptor? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
//            .client(OkHttpClient.Builder().apply {
//                addInterceptor(HttpLoggingInterceptor(logger).apply {
//                    level = HttpLoggingInterceptor.Level.BODY
//                })
//                interceptor?.let { addInterceptor(it) }
//            }.build())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getMeals(): MealsCategoriesResponse {
        Log.d("APIServices", Gson().toJson(api.getMeals()))
        return api.getMeals()
    }

    interface MealsApi {
        @GET("categories.php")
        suspend fun getMeals() : MealsCategoriesResponse
    }

    val logger =  HttpLoggingInterceptor.Logger {
        Log.d("LogTrace", it)
    }
}