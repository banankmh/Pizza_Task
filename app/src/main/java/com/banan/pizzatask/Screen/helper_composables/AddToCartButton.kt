package com.banan.pizzatask.Screen.helper_composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.pizzatask.R
import com.banan.pizzatask.ui.theme.buttonColor

@Preview
@Composable
fun AddToCartButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        modifier = modifier.padding(16.dp)
    ) {
        Image(
            painterResource(id = R.drawable.ic_cart),
            contentDescription = "Cart button icon"
        )
        Text(text = "Add to cart", Modifier.padding(start = 10.dp))
    }
}
