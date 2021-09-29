package com.masai.paging3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.masai.networkpaging3.data.CharacterRepository
import com.masai.networkpaging3.model.CharacterDTO

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun searchResults(): LiveData<PagingData<CharacterDTO>> {
        return characterRepository.getSearchResults()
    }
}