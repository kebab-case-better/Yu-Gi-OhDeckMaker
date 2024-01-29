package fr.uha.dev.deckbuilder.model

import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "extension_card_associations",
    primaryKeys = ["setName", "cid"],

    indices = [Index("cid"), Index("setName")]
)
data class ExtensionCardAssociation(
    val setName: String,
    val cid: Long,
)
