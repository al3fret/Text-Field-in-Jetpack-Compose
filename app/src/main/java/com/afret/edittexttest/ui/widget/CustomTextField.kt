package com.afret.edittexttest.ui.widget


import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.afret.edittexttest.R
import com.afret.edittexttest.ui.theme.ColorPlatinum
import com.afret.edittexttest.ui.util.TextFieldType


@Composable
fun CustomTextField(
    modifier: Modifier,
    text: String,
    textStyle: TextStyle,
    @StringRes hint: Int,
    hintTextStyle: TextStyle,
    onValueChange: (String) -> Unit,
    color: Color,
    cornerRadius: Dp = 0.dp,
    type: TextFieldType

) {


    var passwordVisible by remember {
        mutableStateOf(true)
    }

    var trailingId = when (type) {

        TextFieldType.Password -> R.drawable.ic_visibility_on
        else -> null
    }


    if (trailingId != null) {

        trailingId =
            if (passwordVisible) R.drawable.ic_visibility_off else R.drawable.ic_visibility_on
    }

    TextField(
        modifier = modifier
            .background(color = color, shape = RoundedCornerShape(cornerRadius))
            .fillMaxWidth(),
        value = text,
        textStyle = textStyle,
        onValueChange = onValueChange,
        label = {
            Text(text = stringResource(id = hint), style = hintTextStyle, softWrap = true)
        },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = ColorPlatinum,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        visualTransformation =
        if (type == TextFieldType.Password) {

            if (passwordVisible) PasswordVisualTransformation() else VisualTransformation.None

        } else VisualTransformation.None,
        trailingIcon = {

            if (trailingId != null) {

                Icon(
                    modifier = Modifier.clickable {
                        passwordVisible = !passwordVisible
                    },
                    painter = painterResource(id = trailingId), contentDescription = "password",
                    tint = ColorPlatinum
                )
            }
        }


    )


}

