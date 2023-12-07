package fr.uha.dev.deckbuilder.ui.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fr.uha.dev.android.ui.AppMenu
import fr.uha.dev.android.ui.AppMenuEntry
import fr.uha.dev.android.ui.AppTitle
import fr.uha.dev.android.ui.ErrorScreen
import fr.uha.dev.android.ui.LoadingScreen
import fr.uha.dev.deckbuilder.R
import fr.uha.dev.deckbuilder.model.Card
import fr.uha.dev.deckbuilder.model.Type

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCardScreen(
    vm: CardViewModel = hiltViewModel(),
    back: () -> Unit
) {
    val state by vm.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = vm.isLaunched) {
        if (!vm.isLaunched) {
            val card = Card(
                0,
                "",
                "",
                "0",
                Type.TRAP,
                false,
                null,
                null,
                null
            )
            vm.create(card)
            vm.isLaunched = true
        }
    }

    val menuEntries = listOf(
        AppMenuEntry.ActionEntry(
            title = R.string.save,
            icon = Icons.Filled.Save,
            enabled = state.isSavable(),
            listener = { vm.save() }
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    AppTitle(
                        appNameId = R.string.app_name,
                        pageTitleId = R.string.person_create,
                        isModified = state.isModified()
                    )
                },
                actions = { AppMenu(entries = menuEntries) }
            )
        }
    )
    {
        Column(
            modifier = Modifier.padding(it)
        ) {
            when (state.initialState) {
                CardViewModel.CardState.Loading ->
                    LoadingScreen(text = stringResource(id = R.string.loading))

                CardViewModel.CardState.Error ->
                    ErrorScreen(text = stringResource(id = R.string.error))

                is CardViewModel.CardState.Success ->
                    SuccessPersonScreen(state, vm.uiCallback)
            }
        }
    }
}

