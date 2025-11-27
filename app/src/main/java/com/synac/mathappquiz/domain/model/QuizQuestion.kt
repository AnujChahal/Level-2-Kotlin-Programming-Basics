package com.synac.mathappquiz.domain.model

data class QuizQuestion (
    val text: String,
    val answer: Int,
    val options: List<Int>
)