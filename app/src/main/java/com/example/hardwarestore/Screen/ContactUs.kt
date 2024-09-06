package com.example.hardwarestore.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Subject
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Subject
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hardwarestore.R

@Composable
fun Contact() {
    // dark theme
    val LocalDarkTheme = staticCompositionLocalOf { false }
    val darkTheme = LocalDarkTheme.current
    var name by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var conpassword by remember { mutableStateOf("") }
    val (checked, onCheckedChange) = rememberSaveable {
        mutableStateOf(false)

    }

    Column(modifier = Modifier) {
        Spacer(modifier = Modifier.height(70.dp))
        Box(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Column(
                modifier = Modifier
                    .padding(16.dp)

                    .background(
                        color = colorResource(id = R.color.white),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Send Us A Message",color = if (darkTheme) Color.White else Color.Black,
                            fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.name),color = if (darkTheme) Color.White else Color.Black,
                            style = MaterialTheme.typography.labelLarge
                        )
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.Person, contentDescription = "Name Icon",tint = if (darkTheme) Color.Black else Color.Gray)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = contact,
                    onValueChange = { contact = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.contact_number),color = if (darkTheme) Color.White else Color.Black,
                            style = MaterialTheme.typography.labelLarge
                        )
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.Call, contentDescription = "Call Icon",tint = if (darkTheme) Color.Black else Color.Gray)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(5.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(
                            text = "Email Address",color = if (darkTheme) Color.White else Color.Black,
                            style = MaterialTheme.typography.labelLarge
                        )
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.Email, contentDescription = "Email Icon",tint = if (darkTheme) Color.Black else Color.Gray)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(5.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            text = "Subject",color = if (darkTheme) Color.White else Color.Black,
                            style = MaterialTheme.typography.labelLarge
                        )
                    },
                    leadingIcon = {
                        Icon(Icons.AutoMirrored.Filled.Subject, contentDescription = "subject Icon",tint = if (darkTheme) Color.Black else Color.Gray)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(5.dp))
                OutlinedTextField(
                    value = conpassword,
                    onValueChange = { conpassword = it },
                    label = {
                        Text(
                            text = "Message",color = if (darkTheme) Color.White else Color.Black,
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier
                        )
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.MailOutline, contentDescription = "mail",tint = if (darkTheme) Color.Black else Color.Gray)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Send", fontSize = 20.sp, fontWeight = FontWeight.Bold,color = if (darkTheme) Color.White else Color.White)
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(Icons.Filled.Send, contentDescription = "send icon",tint = if (darkTheme) Color.Black else Color.White)
                }
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                Text(text = "Or Contact Us Via",style = MaterialTheme.typography.bodyLarge,color = if (darkTheme) Color.White else Color.Black)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 80.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painterResource(id = R.drawable.facebook),
                        contentDescription = "facebook",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { }
                    )
                    Image(
                        painterResource(id = R.drawable.whatsapp),
                        contentDescription = "whatsapp",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { }
                    )
                    Image(
                        painterResource(id = R.drawable.instergram),
                        contentDescription = "instagram",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { }
                    )
                }


            }
            Spacer(modifier = Modifier.height(300.dp))

        }

    }

}