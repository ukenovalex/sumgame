package ru.ukenov.sumgame.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import ru.ukenov.sumgame.R
import ru.ukenov.sumgame.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        count
    )
}

@BindingAdapter("scoreAnswers")
fun bindingScoreAnswers(textView: TextView, score: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        score
    )
}

@BindingAdapter("requirePercentage")
fun bindingRequirePercentage(textView: TextView, percent: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        percent
    )
}

@BindingAdapter("emojiResult")
fun bindingEmojiResult(image: ImageView, winner: Boolean) {
    image.setImageResource(getSmileResId(winner))
}

@BindingAdapter("scorePercentage")
fun bindingScorePercentage(textView: TextView, gameResult: GameResult) {
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        getPercentOfRightAnswers(gameResult)
    )
}

@BindingAdapter("progressBar")
fun bindingProgressBar(progressBar: ProgressBar, value: Int) {
    progressBar.setProgress(value, true)
}

@BindingAdapter("enoughCountOfRightAnswers")
fun bindingEnoughCountOfRightAnswers(textView: TextView, value: Boolean) {
    textView.setTextColor(getColorByState(textView.context, value))
}

@BindingAdapter("enoughPercentOfRightAnswers")
fun bindingEnoughPercentOfRightAnswers(bar: ProgressBar, value: Boolean) {
    val color = getColorByState(bar.context, value)
    bar.progressTintList = ColorStateList.valueOf(color)
}

@BindingAdapter("numberAsText")
fun bindingNumberAsText(textView: TextView, number: Int) {
    textView.text = number.toString()
}

@BindingAdapter("onClickOptionListener")
fun bindingOnClickOptionListener(textView: TextView, optionClick: OptionClick) {
    textView.setOnClickListener {
        optionClick.onClick(textView.text.toString().toInt())
    }
}

interface OptionClick {
    fun onClick(option: Int)
}


private fun getColorByState(context: Context, goodState: Boolean): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}

private fun getSmileResId(winner: Boolean): Int {
    return if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
}

private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
}
