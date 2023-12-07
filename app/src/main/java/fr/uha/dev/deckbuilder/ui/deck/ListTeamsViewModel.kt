package fr.uha.dev.deckbuilder.ui.deck

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.uha.dev.deckbuilder.database.FeedDatabase
import fr.uha.dev.deckbuilder.repository.DeckRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListTeamsViewModel @Inject constructor (
    private val repository: DeckRepository
) : ViewModel() {
    fun feed() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            FeedDatabase().populate()
        }
    }

    fun clean() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            FeedDatabase().clear()
        }
    }

    val teams = repository.getAll()

}
