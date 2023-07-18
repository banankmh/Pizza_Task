package com.banan.pizzatask.Screen.helper_composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.pizzatask.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(modifier: Modifier = Modifier) { Scaffold(topBar = {
            TopAppBar(
                modifier = modifier.padding(horizontal = 16.dp),
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_back),
                        contentDescription = "back icon",
                    )
                },
                title = {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "Pizza",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.ic_heart),
                        contentDescription = "favorite icon"
                    )
                }
            )
        }) {} }

@Preview(showSystemUi = true)
@Composable
fun Preview(){
    CustomAppBar()
}

