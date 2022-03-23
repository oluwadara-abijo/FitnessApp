package com.dara.fitnessapp.ui.composables

import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.*
import com.dara.fitnessapp.ui.theme.BluePrimary

@Composable
fun CustomCheckBox() {
    var isChecked by remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked,
        onCheckedChange = {
            isChecked = it
        },
        colors = CheckboxDefaults.colors(
            BluePrimary
        )
    )
}