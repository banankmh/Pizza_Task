package com.banan.pizzatask.Screen.helper_composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.banan.pizzatask.ui.theme.secondary

@Composable
fun SecondaryText(modifier: Modifier = Modifier,text:String) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = secondary,
        modifier = modifier
    )
}