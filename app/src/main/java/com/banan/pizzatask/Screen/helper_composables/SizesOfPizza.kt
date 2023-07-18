package com.banan.pizzatask.Screen.helper_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banan.pizzatask.ui.theme.onPrimary
import com.banan.pizzatask.ui.theme.primary


@Composable
private fun SizesOfPizza(
    text: String,
    selected: Boolean,
  //toDo  onPizzaSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isSelected = remember { mutableStateOf(selected) }

    Box(
        modifier = modifier
            .clickable {
                if (!isSelected.value) {
                    isSelected.value = true
                // toDo onPizzaSelected()
                }
            }
            .padding(vertical = 4.dp)
            .size(48.dp)
            .background(
                color = if (isSelected.value) onPrimary else onPrimary,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        if (isSelected.value) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(onPrimary, shape = CircleShape)
                    .shadow(elevation = 1.dp, shape = CircleShape, spotColor = primary )
            )
        }
        SizeText(text=text)
    }
}

@Composable
private fun SizeText(text:String){
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.Monospace,
        color = primary
    )
}

@Composable
fun SizesRow(sizes: List<String>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth()
    ) {
        sizes.forEach { size ->
            SizesOfPizza(
                text = size,
                selected = false,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
            )
        }
    }
}






