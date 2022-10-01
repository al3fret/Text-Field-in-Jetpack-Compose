package com.afret.edittexttest.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afret.edittexttest.R
import com.afret.edittexttest.ui.theme.ColorGunmetal
import com.afret.edittexttest.ui.util.TextFieldType
import com.afret.edittexttest.ui.widget.AuthenticationTextFields


@Composable
fun TestTextFieldScreen() {


    var email by remember {
        mutableStateOf("")
    }


    var password by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorGunmetal)
    ) {

        AuthenticationTextFields(
            modifier = Modifier.fillMaxWidth(0.85f),
            text = email, hint = R.string.email,
            onValueChange ={
                email = it
            },
            type = TextFieldType.Email
        )

        Spacer(modifier = Modifier.height(20.dp))


        AuthenticationTextFields(
            modifier = Modifier.fillMaxWidth(0.85f),
            text = password, hint = R.string.password,
            onValueChange ={
                password = it
            },
            type = TextFieldType.Password
        )
    }
}


@Composable
@Preview
fun TestTextFieldScreenPreview() {

    TestTextFieldScreen()
}