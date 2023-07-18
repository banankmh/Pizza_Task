package com.banan.pizzatask.Screen

data class CreatePizzaUiState(
    var isSmall :Boolean = false,
    var isMedium :Boolean = false,
    var isLarge :Boolean = false,
    var pizzaSize : Float = 156f
    )