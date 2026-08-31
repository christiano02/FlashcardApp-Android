package com.christiano.flashcardsapp.ui.flashcard

import com.christiano.flashcardsapp.data.model.FlashcardApp

//O retrato exato de tudo que a tela precisa saber para se desenhar
data class FlashcardUiState(
    val listaDeCartoes: List<FlashcardApp> = emptyList(),
    val indiceAtual: Int = 0,
    val estaVirado: Boolean = false
){
    //uma propriedade facilitadora para gerarmos rapidamente a musica atual
    val cartaoAtual: FlashcardApp?
        get() = listaDeCartoes.getOrNull(indiceAtual)
}