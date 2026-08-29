package com.christiano.flashcardsapp.data.repository

import com.christiano.flashcardsapp.data.model.FlashcardApp

class FlashcardAppRepository {

    // Função que retorna a nossa lista de músicas
    fun obterFlashcards(): List<FlashcardApp> {
        return listOf(
            FlashcardApp(
                trechoIngles = "And that's where I find a glimpse of us",
                traducaoPTbr = "E é aí que eu encontro um vislumbre de nós",
                notasPronuncia = "glimpse (glimps) = vislumbre, relance rápida"
            ),
            FlashcardApp(
                trechoIngles = "I only love my bed and my momma, I'm sorry",
                traducaoPTbr = "Eu só amo minha cama e minha mãe, me desculpe",
                notasPronuncia = "momma = termo carinhoso e informal para mãe (mother)"
            ),
            FlashcardApp(
                trechoIngles = "Glimpse of us, catching my breath",
                traducaoPTbr = "Vislumbre de nós, recuperando o fôlego",
                notasPronuncia = "catching my breath = expressão para 'recuperar o fôlego'"
            ),
            FlashcardApp(
                trechoIngles = "Hold on, we're going home",
                traducaoPTbr = "Aguente firme, estamos indo para casa",
                notasPronuncia = "Hold on = phrasal verb para esperar ou aguentar firme"
            )
        )
    }
}