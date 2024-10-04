package com.example.testhh1.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testhh1.R
import com.example.testhh1.domain.Repository
import com.example.testhh1.domain.models.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val state = MutableStateFlow(SearchState())
    fun observeUi() = state.asStateFlow()

    init {
        getResponse()
    }

    private fun getResponse() {
        viewModelScope.launch {
            try {
                val response = repository.makeRequest()
                state.update { it.copy(response = response, error = null) }
            } catch (e: Exception) {
                state.update { it.copy(error = R.string.error_message) }
            }
        }
    }
}

data class SearchState(
    val response: Response? = null,
    val error: Int? = null
)