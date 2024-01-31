package fr.uha.dev.deckbuilder.model

import androidx.room.Embedded

class CardWithDetails(
    @Embedded
    val card: Card,
)