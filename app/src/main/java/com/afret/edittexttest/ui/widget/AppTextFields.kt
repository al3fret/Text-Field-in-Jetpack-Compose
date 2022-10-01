package com.afret.edittexttest.ui.widget

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.afret.edittexttest.ui.theme.ColorAmericanPurple
import com.afret.edittexttest.ui.theme.cairoFontNormalGray14
import com.afret.edittexttest.ui.theme.cairoFontSemiBoldPlatinum16
import com.afret.edittexttest.ui.util.TextFieldType


@Composable
fun AuthenticationTextFields(
    modifier: Modifier,
    text: String,
    @StringRes hint: Int,
    onValueChange: (String) -> Unit,
    type: TextFieldType

) {

    CustomTextField(
        modifier = modifier,
        text = text,
        textStyle = cairoFontSemiBoldPlatinum16,
        hint = hint,
        hintTextStyle = cairoFontNormalGray14,
        onValueChange = onValueChange,
        color = ColorAmericanPurple,
        cornerRadius = 10.dp,
        type = type
    )

}