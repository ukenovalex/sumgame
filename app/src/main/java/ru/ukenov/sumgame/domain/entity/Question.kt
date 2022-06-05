package ru.ukenov.sumgame.domain.entity

data class Question (
    val sum: Int,
    val visibleNumber: Int,
    val options: List<Int>
) {
    val rightAnswer
        get() = sum - visibleNumber
}