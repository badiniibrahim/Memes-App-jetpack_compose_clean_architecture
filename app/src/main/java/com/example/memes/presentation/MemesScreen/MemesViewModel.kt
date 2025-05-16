package com.example.memes.presentation.MemesScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memes.domain.repository.MemesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemesViewModel @Inject constructor(
    private val memesRepository: MemesRepository
): ViewModel() {
    private val _state = MutableStateFlow(MemesViewState())
    val state = _state.asStateFlow()

    init {
        getMemes()
    }
    private fun getMemes(){
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            memesRepository.getAllMemes().onRight {data ->
                _state.update {
                    it.copy(memesData = data.data.memes)
                }
            }.onLeft {error ->
                _state.update {
                    it.copy(errorMessage = error.error.message)
                }
            }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}