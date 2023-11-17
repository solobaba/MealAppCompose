package com.example.coreuiimpl.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coreuiimpl.model.repository.MealsRepository
import com.example.coreuiimpl.model.response.MealResponse
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository.getInstance()
) : ViewModel() {

    private val mealsJob = Job()

    init {
        //val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealState.value = meals
        }
    }

    val mealState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    private suspend fun getMeals() : List<MealResponse> {
        Log.d("Categories", Gson().toJson(repository.getMeals().categories))
        return repository.getMeals().categories
    }

//    override fun onCleared() {
//        super.onCleared()
//        mealsJob.cancel()
//    }
}