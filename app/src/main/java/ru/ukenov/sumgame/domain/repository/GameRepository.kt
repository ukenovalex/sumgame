package ru.ukenov.sumgame.domain.repository

import ru.ukenov.sumgame.domain.entity.GameSettings
import ru.ukenov.sumgame.domain.entity.Level
import ru.ukenov.sumgame.domain.entity.Question

interface GameRepository {
    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question
    fun getGameSettings(level: Level): GameSettings
}