package com.banan.pizzatask.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.banan.pizzatask.R
import com.banan.pizzatask.Screen.helper_composables.AddToCartButton
import com.banan.pizzatask.Screen.helper_composables.CustomAppBar
import com.banan.pizzatask.Screen.helper_composables.IngredientsRow
import com.banan.pizzatask.Screen.helper_composables.SecondaryText
import com.banan.pizzatask.Screen.helper_composables.SizesRow
import com.banan.pizzatask.Screen.helper_composables.TextPrice


@Composable
fun CreatePizzaContent() {
    CreatePizzaScreen()

}

@Composable
private fun CreatePizzaScreen() { ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (
            topAppBar,
            plate,
            price,
            sizesOfPizza,
            ingredientsRow,
            customizeText,
            addToCartButton
        ) = createRefs()

        // region appbar
        CustomAppBar(modifier = Modifier.constrainAs(topAppBar) {
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        //endregion

        ///region plate
        Image(
            painter = painterResource(R.drawable.plate),
            contentDescription = "",
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 90.dp)
                .constrainAs(plate) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(topAppBar.bottom)
                }
                .height(240.dp)
        )
        ///endregion

        //region price
        TextPrice("17$", modifier = Modifier.constrainAs(price) {
            top.linkTo(plate.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        //endregion

        //region sizes
        val sizes = listOf("S", "M", "L")
        SizesRow(
            sizes = sizes,
            modifier = Modifier.constrainAs(sizesOfPizza) {
                top.linkTo(price.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        //endregion

        //region text
        SecondaryText(
            text = "Customize your Pizza",
            modifier = Modifier.constrainAs(customizeText) {
            top.linkTo(sizesOfPizza.bottom)
            start.linkTo(parent.start, margin = 16.dp)
            bottom.linkTo(ingredientsRow.top, margin = 8.dp)
        })
       //endregion

        //region ingredients
        IngredientsRow(modifier = Modifier.constrainAs(ingredientsRow) {
            top.linkTo(customizeText.bottom, margin = 8.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        // endregion

        // region add to cart
        AddToCartButton(modifier = Modifier.constrainAs(addToCartButton) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom, margin = 16.dp)
        })
        //endregion

    } }

@Preview(showSystemUi = true)
@Composable
fun CreatePizzaPreview() { CreatePizzaScreen() }