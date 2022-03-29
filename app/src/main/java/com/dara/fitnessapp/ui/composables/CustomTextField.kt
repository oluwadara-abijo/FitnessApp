package com.dara.fitnessapp.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dara.fitnessapp.R

@Composable
fun CustomTextField(
    label: String,
    @DrawableRes
    drawableRes: Int = R.drawable.ic_profile,
    contentDescription: String = stringResource(R.string.person_icon),
    paddingTop: Dp = 12.dp
) {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, paddingTop),
        value = text,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            placeholderColor = colorResource(id = R.color.grey_primary),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = colorResource(id = R.color.ghost_white)
        ),
        onValueChange = { input ->
            text = input
        },
        placeholder = {
            Text(text = label)
        },
        leadingIcon = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = drawableRes),
                    contentDescription = contentDescription,
                    tint = colorResource(id = R.color.grey_secondary)
                )
            }
        }
    )
}

@Composable
fun CustomPasswordTextField(
    paddingTop: Dp = 12.dp
) {
    var text by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) R.drawable.hide_password else R.drawable.show_password

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, paddingTop),
        value = text,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            placeholderColor = colorResource(id = R.color.grey_primary),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = colorResource(id = R.color.ghost_white)
        ),
        onValueChange = { input ->
            text = input
        },
        placeholder = {
            Text(text = stringResource(R.string.password))
        },
        leadingIcon = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_lock),
                    contentDescription = stringResource(R.string.password_visibility_icon),
                    tint = colorResource(id = R.color.grey_secondary)
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = stringResource(R.string.password_visibility_icon),
                    tint = colorResource(id = R.color.grey_secondary)
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else
            PasswordVisualTransformation()
    )
}