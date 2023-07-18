package com.banan.pizzatask.Screen.helper_composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.banan.pizzatask.R
import com.banan.pizzatask.ui.theme.ingredientsBackground

@Composable
private fun Ingredients(modifier: Modifier = Modifier) {
    val imageList = listOf(
        R.drawable.basil_1,
        R.drawable.onion_2,
        R.drawable.broccoli_1,
        R.drawable.mushroom_1,
        R.drawable.sausage_1
    )

    val selectedImageIndices = remember { mutableStateListOf<Int>() }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(imageList.size) { index ->
            val isSelected = selectedImageIndices.contains(index)

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) ingredientsBackground else Color.Transparent)
                    .clickable {
                        if (isSelected) {
                            selectedImageIndices.remove(index)
                        } else {
                            selectedImageIndices.add(index)
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
            Image(
                    painter = painterResource(imageList[index]),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}
@Composable
fun IngredientsRow(modifier: Modifier = Modifier) {
    Ingredients(modifier = modifier.padding(vertical = 16.dp))
}