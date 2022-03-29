package com.dara.fitnessapp.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.dara.fitnessapp.R

@Composable
fun CustomDropDownField(
    label: String,
    @DrawableRes
    drawableRes: Int = R.drawable.ic_profile,
    contentDescription: String = stringResource(R.string.person_icon),
    paddingTop: Dp = 12.dp,
    options: List<String> = listOf("Male", "Female")
) {
    var text by rememberSaveable { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }
    var fieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (isExpanded)
        Icons.Filled.KeyboardArrowUp else Icons.Filled.ArrowDropDown


    Column() {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned {
                    fieldSize = it.size.toSize()
                }
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
            },
            trailingIcon = {
                IconButton(onClick = {
                    isExpanded = !isExpanded
                }) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "DropDown Icon"
                    )
                }
            },
            readOnly = true
        )

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            modifier = Modifier.width(
                with(LocalDensity.current) {
                    fieldSize.width.toDp()
                }
            )
        ) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    text = option
                }) {
                    Text(text = option)
                }
            }
        }
    }
}