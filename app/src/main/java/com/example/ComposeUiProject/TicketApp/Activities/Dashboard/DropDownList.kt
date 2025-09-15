@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ComposeUiProject.TicketApp.Activities.Dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.ComposeUiProject.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownList(
    items: List<String>,
    loadingIcon: Painter,
    hint: String = "",
    showLocationLoading: Boolean,
    onItemSelected: (String) -> Unit,
) {
    var selectedItem by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {

        if (showLocationLoading) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(
                        colorResource(R.color.lightPurple_ticket),
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .background(
                        colorResource(R.color.lightPurple_ticket),
                        shape = RoundedCornerShape(10.dp)
                    ),
            ) {
                OutlinedTextField(
                    value = selectedItem,
                    onValueChange = { selectedItem = it },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .menuAnchor(),
                    placeholder = {
                        Box(
                            modifier = Modifier.height(20.dp),
                            contentAlignment = Alignment.Start as Alignment
                        ) {
                            Text(
                                text = hint,
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                        }
                    },
                    leadingIcon = {
                        Image(
                            painter = loadingIcon,
                            contentDescription = null,
                        )
                    },
                    textStyle = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                    )

                )
            }

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = item,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }
                        },
                        onClick = {
                            selectedItem = item
                            expanded = false
                            onItemSelected(item)
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DropDownListPreview() {
    val items = listOf("Item 1", "Item 2", "Item 3")
    val loadingIcon = painterResource(id = R.drawable.ic_launcher_background)
    DropDownList(
        items = items,
        loadingIcon = loadingIcon,
        hint = "Select an item",
        showLocationLoading = false,
        onItemSelected = {}
    )
}
