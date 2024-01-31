package fr.uha.dev.deckbuilder.ui.collection

import fr.uha.dev.deckbuilder.R
import fr.uha.dev.deckbuilder.model.Condition
import fr.uha.dev.deckbuilder.model.Language
import fr.uha.dev.deckbuilder.model.Rarity

object CollectionUIValidator {

    fun validateConditionChange(newValue: Condition?): Int? {
        if (newValue == null) return R.string.condition_must_set
        return null
    }

    fun validateLanguageChange(newValue: Language?): Int? {
        if (newValue == null) return R.string.language_must_set
        return null
    }

    fun validateRarityChange(newValue: Rarity?): Int? {
        if (newValue == null) return R.string.rarity_must_set
        return null
    }

}