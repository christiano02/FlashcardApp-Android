package com.christiano.flashcardsapp.ui.flashcard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.christiano.flashcardsapp.data.repository.FlashcardAppRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class FlashcardViewModel : ViewModel() {
    // chamamos o nosso fornecedor de dados
    private val repositorio = FlashcardAppRepository()

    //criamos o estado da tela
    var uiState by mutableStateOf(FlashcardUiState())
    private set //apenas o ViewModel pode alterar o estado, a tela só pode ler

    //o init roda automaticamente quando o viewModel nasce
    init {
        carregarCartoes()
    }

    private fun carregarCartoes(){
        //pega a lista do repositorio e atualiza o estado
        val cartoes = repositorio.obterFlashcards()
        uiState = uiState.copy(listaDeCartoes = cartoes)
    }

    //a ação que sera chamada pelo botao na tela
    fun aoClicarNobotao() {
        if (!uiState.estaVirado){
            //se p cartão esta de frente so ingles, vira para mostrar a traducao
            uiState = uiState.copy(estaVirado = true)
        } else {
            //se ja revelou, avança para a proxima musica e desvira o cartao
            val proximoIndicice = (uiState.indiceAtual + 1) % uiState.listaDeCartoes.size
            uiState = uiState.copy(
                indiceAtual = proximoIndicice,
                estaVirado = false
            )
        }
    }
}