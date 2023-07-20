package com.banan.pizzatask.Screen.helper_composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.banan.pizzatask.Screen.PizzaUiState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.DelicateCoroutinesApi

@OptIn(ExperimentalAnimationApi::class)
@DelicateCoroutinesApi
@ExperimentalPagerApi
@Composable
fun Pager(
    modifier: Modifier = Modifier,
    item: List<PizzaUiState> = emptyList(),
    pagerState: PagerState,
    pizzaSize: String = "M",
) {

    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .height(320.dp)
            .padding(top = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) { page ->

        val pizzaSize = if (pizzaSize == "S") 200.dp else if (pizzaSize == "M") 210.dp else 250.dp

        val imageSize by animateDpAsState(
            targetValue = pizzaSize,
            animationSpec = tween(100),
        )


        Box(modifier = Modifier) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier
                        .size(imageSize)
                        .align(Alignment.Center),
                    painter = painterResource(id = item[page].pizzaImage), contentDescription = null
                )
            }

            item[page].ingredient.forEachIndexed { index, ingredientUiState ->
                AnimatedVisibility(
                    visible = ingredientUiState.isSelectedIngredient,
                    enter = scaleIn(initialScale = 10f,) ,
                    exit = fadeOut(animationSpec = tween(10))
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            modifier = Modifier
                                .size(imageSize)
                                .align(Alignment.Center),
                            painter = painterResource(id = ingredientUiState.image),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}