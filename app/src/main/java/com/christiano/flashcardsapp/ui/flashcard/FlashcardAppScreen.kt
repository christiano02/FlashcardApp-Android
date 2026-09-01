package com.christiano.flashcardsapp.ui.flashcard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.christiano.flashcardsapp.ui.components.CardView
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashcardAppScreen(
    viewModel: FlashcardViewModel = viewModel()
){
    //observamos o estado gerencia pelo viewModel
    val state = viewModel.uiState
    val cartaoAtual = state.cartaoAtual

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Music FlashCards",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            //indicador de progresso
            Text(
                text = "Musica ${state.indiceAtual + 1} de ${state.listaDeCartoes.size}",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.outline
            )
            //renderização do cartão
            if (cartaoAtual != null) {
                CardView(
                    flashcard = cartaoAtual,
                    estaVirado = state.estaVirado
                )
            }

            //botao de controle de fluxo
            Button(
                onClick = { viewModel.aoClicarNobotao() },
                modifier = Modifier
                    .fillMaxSize()
                    .height(56.dp)
            ) {
                Text(
                    text = if (state.estaVirado) "Proximo Cartão" else "Revelar Tradução",
                    fontSize = 16.sp
                )
            }
        }
    }
}

