package com.example.hardwarestore.Screen

import androidx.annotation.ColorRes
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.* // to import all in remeber
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hardwarestore.R

@Composable
fun Login(
    OnLoginClick:()-> Unit,
    OnSignUpClick:()-> Unit
){
    //dark theme
    val LocalDarkTheme = staticCompositionLocalOf { false }

    val darkTheme = LocalDarkTheme.current
    // to store value of email
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val (checked,onCheckedChange)= rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.green))

    ) {
        Image(
            painter = painterResource( R.drawable.login),
            contentDescription = "login image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp))
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),

        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(
                    color = colorResource(R.color.white),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.welcome_back), fontWeight = FontWeight.Bold,style = MaterialTheme.typography.headlineLarge, color = if (darkTheme) Color.White else Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = stringResource(R.string.login_account), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold,color = if (darkTheme) Color.White else Color.Black)
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = stringResource(R.string.Email_Address), style = MaterialTheme.typography.labelLarge,color = if (darkTheme) Color.White else Color.Black)
                 },
                leadingIcon = {
                    Icon(Icons.Filled.AccountCircle, contentDescription = "Name Icon", tint = if (darkTheme) Color.Black else Color.Gray)
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = stringResource(R.string.password),style = MaterialTheme.typography.labelLarge,color = if (darkTheme) Color.White else Color.Black) },
                leadingIcon = {
                    Icon(Icons.Filled.Lock, contentDescription = "Lock Icon", tint = if (darkTheme) Color.Black else Color.Gray)
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween){
                Row (horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,){
                    Checkbox(checked =checked , onCheckedChange =onCheckedChange, )
                    Text(text = stringResource(R.string.remember_me), style = MaterialTheme.typography.bodyLarge,color = if (darkTheme) Color.White else Color.Black)
                }
                Text(text = stringResource(R.string.forgot_password), modifier = Modifier.clickable { }, color = colorResource(R.color.green),style = MaterialTheme.typography.bodyLarge)

            }
            Button(
                onClick = { OnLoginClick() },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.green)),
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                Text(text = stringResource(R.string.login), fontSize = 20.sp, fontWeight = FontWeight.Bold,color = if (darkTheme) Color.White else Color.White)
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Text(text = stringResource(R.string.sign_in_with),style = MaterialTheme.typography.bodyLarge,color = if (darkTheme) Color.White else Color.Black)
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
                    painterResource(id = R.drawable.google),
                    contentDescription = "google",
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
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

            Row {

                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Don't Have An Account?",color = if (darkTheme) Color.White else Color.Black)
                Text(text = stringResource(R.string.sign_up), modifier = Modifier.clickable {OnSignUpClick() }, color = colorResource(id = R.color.green),style = MaterialTheme.typography.bodyLarge)

            }

        }
    }
}

