package com.banan.pizzatask.Screen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.banan.pizzatask.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CreatePizzaViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(MealUiState())
    val state = _state.asStateFlow()


    init {
        getPizzaSize()
        getPizzaType()
        getIngredient()
    }

    private fun getPizzaType() {
        _state.update {
            it.copy(
                pizza = listOf(
                    PizzaUiState(pizzaImage = R.drawable.bread_1),
                    PizzaUiState(pizzaImage = R.drawable.bread_2),
                    PizzaUiState(pizzaImage = R.drawable.bread_3),
                    PizzaUiState(pizzaImage = R.drawable.bread_4),
                    PizzaUiState(pizzaImage = R.drawable.bread_5),
                )
            )
        }
    }

    private fun getIngredient() {
        _state.update {
            it.copy(pizza = it.pizza.map {
                it.copy(ingredient = listOf(
                    IngredientUiState(id = 0, imageIcon = R.drawable.basil_1, image = R.drawable.basil_1),
                    IngredientUiState(id = 1, imageIcon = R.drawable.broccoli_1, image = R.drawable.broccoli_1),
                    IngredientUiState(id = 2, imageIcon = R.drawable.sausage_1, image = R.drawable.sausage_1),
                    IngredientUiState(id = 3, imageIcon = R.drawable.onion_1, image = R.drawable.onion_1),
                    IngredientUiState(id = 4, imageIcon = R.drawable.mushroom_1, image = R.drawable.mushroom_1),
                )
                )
            }
            )
        }
    }

    private fun getPizzaSize() {
        _state.update {
            it.copy(
                pizzaSize = listOf(
                    PizzaSizeUiState(
                        pizzaSize = "S",
                        isSelected = false
                    ),
                    PizzaSizeUiState(
                        pizzaSize = "M",
                        isSelected = true
                    ),
                    PizzaSizeUiState(
                        pizzaSize = "L",
                        isSelected = false
                    )
                )
            )
        }
    }

    fun onClickPizzaSize(selectedPizzaSize: String) {
        _state.update { currentState ->
            val updatedDates = currentState.pizzaSize.map { pizza ->
                if (pizza.pizzaSize == selectedPizzaSize) {
                    pizza.copy(isSelected = !pizza.isSelected)
                } else {
                    pizza.copy(isSelected = false)
                }
            }
            currentState.copy(pizzaSize = updatedDates, selectedPizzaSize = selectedPizzaSize)
        }
    }

    fun onClickIngredient(IngredientIndex: Int, currentIngredient: Int) {
        _state.update {
            it.copy(
                it.pizza.mapIndexed { pizzaIndex, pizza ->
                    if (pizzaIndex == currentIngredient) {
                        pizza.copy(
                            ingredient = pizza.ingredient.mapIndexed { index, ingredient ->
                                if (index == IngredientIndex) {
                                    ingredient.copy(isSelectedIngredient = !ingredient.isSelectedIngredient)
                                } else {
                                    ingredient.copy(isSelectedIngredient = ingredient.isSelectedIngredient)
                                }
                            },
                        )
                    } else {
                        pizza.copy(
                            ingredient = pizza.ingredient.mapIndexed { index, ingredient ->
                                ingredient.copy(isSelectedIngredient = ingredient.isSelectedIngredient)
                            },
                        )
                    }
                },
                currentPage = currentIngredient,
            )
        }


    }
}
    

