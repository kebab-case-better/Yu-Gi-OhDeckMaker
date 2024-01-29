package fr.uha.dev.deckbuilder.repository

import fr.uha.dev.deckbuilder.database.CardDao
import fr.uha.dev.deckbuilder.database.CollectionCardDao
import fr.uha.dev.deckbuilder.database.ExtensionDao
import fr.uha.dev.deckbuilder.model.Card
import fr.uha.dev.deckbuilder.model.CollectionCard
import fr.uha.dev.deckbuilder.model.CollectionCardAssociation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class CollectionCardRepository(
    private val collectionCardDao: CollectionCardDao,

) {
    suspend fun addCardToCollection(collectionCard: CollectionCard) {
        withContext(Dispatchers.IO) {
        }
    }
    suspend fun editCardInCollection(collectionCard: CollectionCard) {
        withContext(Dispatchers.IO) {
        }
    }

    suspend fun updateCollectionCard(card: CollectionCard) {
        collectionCardDao.update(card)
    }

    fun getAllCollectionCards(): Flow<List<CollectionCard>> {
        return collectionCardDao.getAll()
    }
}
