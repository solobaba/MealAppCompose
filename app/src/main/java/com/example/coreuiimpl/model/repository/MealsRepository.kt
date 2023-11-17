package com.example.coreuiimpl.model.repository

import android.util.Log
import com.example.coreuiimpl.model.api.MealsWebService
import com.example.coreuiimpl.model.response.MealResponse
import com.example.coreuiimpl.model.response.MealsCategoriesResponse
import com.google.gson.Gson

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    private var cachedMeals = listOf<MealResponse>()

    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        Log.d("RepoServices", Gson().toJson(webService.getMeals()))
        return response
    }

    fun getMeal(id: String) : MealResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance : MealsRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance?: MealsRepository().also { instance = it }
        }
    }
}