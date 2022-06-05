package ru.ukenov.sumgame.domain.usecases

import ru.ukenov.sumgame.domain.entity.GameSettings
import ru.ukenov.sumgame.domain.entity.Level
import ru.ukenov.sumgame.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}