package com.example.testhh1.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testhh1.R
import com.example.testhh1.domain.Repository
import com.example.testhh1.domain.models.Offer
import com.example.testhh1.domain.models.Vacancy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SaveViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val state = MutableStateFlow(SaveState())
    fun observeUi() = state.asStateFlow()

    init {
        getResponse()
    }

    private fun getResponse() {
        viewModelScope.launch {
            try {
                val response = repository.makeRequest()
                val vacancies = response.vacancies
                val favVacancies = mutableListOf<Vacancy>()
                for(i in vacancies){
                    if (i.isFavorite){
                        favVacancies.add(i)
                    }
                }
                state.update { it.copy(vacancies = favVacancies, error = null) }
            } catch (e: Exception) {
                state.update { it.copy(error = R.string.error_message) }
            }
        }
    }
}

data class SaveState(
    val vacancies: List<Vacancy>? = null,
    val error: Int? = null
)