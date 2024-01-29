package fr.uha.dev.deckbuilder.repository

import android.util.Log
import androidx.annotation.WorkerThread
import fr.uha.dev.deckbuilder.database.CardDao
import fr.uha.dev.deckbuilder.database.ExtensionDao
import fr.uha.dev.deckbuilder.model.Card
import fr.uha.dev.deckbuilder.model.Extension
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow


class ExtensionRepository(private val extensionDao: ExtensionDao, private val cardDao: CardDao){
    @WorkerThread
    fun getExtensions(): Flow<List<Extension>> {
        return extensionDao.getExtensions()
    }

    fun getCardsInExtension(name: String): Flow<List<Card>> {
        return extensionDao.getCardsInExtension(name)
    }

}