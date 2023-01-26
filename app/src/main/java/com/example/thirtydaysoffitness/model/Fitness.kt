package com.example.thirtydaysoffitness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Fitness(
    @StringRes val day: Int,
    @StringRes val exercise: Int,
    @StringRes val reps: Int,
    @StringRes val description: Int,
    @DrawableRes val descriptionImage: Int
)