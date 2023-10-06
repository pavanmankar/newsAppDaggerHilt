package com.example.newstrending.ui.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newstrending.data.model.Article
import com.example.newstrending.data.repository.TopHeadlineRepository
import com.example.newstrending.ui.base.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class SearchViewModel(private val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Article>>> = _uiState


    fun fetchHeadlineNewsBySearch(query:String){
        viewModelScope.launch {
            topHeadlineRepository.getTopHeadlines("IN",query)
                .catch { error ->
                    _uiState.value = UiState.Error(error.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }


}