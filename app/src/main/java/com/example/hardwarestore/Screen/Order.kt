package com.example.hardwarestore.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.hardwarestore.R
import com.example.hardwarestore.ui.theme.WindowSize
import com.example.hardwarestore.ui.theme.WindowType
import com.example.hardwarestore.ui.theme.rememberWindowSize

@Composable
fun Order() {
    val windowSize = rememberWindowSize()
    when (windowSize.width) {
        WindowType.Compact -> {CompactOrder()
    } else ->{
        MediumToExpendedOrder()
    }
}


}
@Composable
fun CompactOrder(){
    // dark theme
    val LocalDarkTheme = staticCompositionLocalOf { false }
    val darkTheme = LocalDarkTheme.current
    val (checked,onCheckedChange)= rememberSaveable {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .padding(top = 2.dp, end = 2.dp)
        .verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "Ordered Items",color = if (darkTheme) Color.White else Color.White ,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Card(
            modifier = Modifier
                .height(100.dp)
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Row (modifier = Modifier
                .background(
                    color = colorResource(R.color.white)
                )
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp), horizontalArrangement = Arrangement.SpaceAround){
                Checkbox(checked =checked, onCheckedChange =onCheckedChange, modifier = Modifier.fillMaxHeight())
                Image(
                    painter = painterResource(R.drawable.doorhandle),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(10.dp)
                        .weight(1f)
                )

                Column (modifier = Modifier .weight(1f)){
                    Text(text ="Door Handle",style = MaterialTheme.typography.bodyLarge ,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "By AarkayVox",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "AarkayVox Lever Handle",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "Rs.4500",color = if (darkTheme) Color.White else Color.Black )

                }
                Column (modifier = Modifier
                    .padding(2.dp)
                    .weight(1f), horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(Icons.Filled.Favorite, contentDescription = "mail", modifier = Modifier.fillMaxWidth(),
                        Color.Red)
                    Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Pay Now",color = if (darkTheme) Color.White else Color.White )


                    }
                }

            }

        }
        Card(
            modifier = Modifier
                .height(100.dp)
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Row (modifier = Modifier
                .background(
                    color = colorResource(R.color.white)
                )
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp), horizontalArrangement = Arrangement.SpaceAround){
                Checkbox(checked =checked, onCheckedChange =onCheckedChange, modifier = Modifier.fillMaxHeight())
                Image(
                    painter = painterResource(R.drawable.balllcok),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(10.dp)
                        .weight(1f)
                )

                Column (modifier=Modifier .weight(1f)){
                    Text(text ="Ball Handle",style = MaterialTheme.typography.bodyLarge ,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "By Yall",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "Ball Lock 60mm Room",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "Rs.8500",color = if (darkTheme) Color.White else Color.Black )

                }
                Column (modifier = Modifier
                    .padding(2.dp)
                    .weight(1f), horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(Icons.Filled.Favorite, contentDescription = "mail", modifier = Modifier.fillMaxWidth(),
                        Color.Red)
                    Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Pay Now",color = if (darkTheme) Color.White else Color.White )


                    }
                }

            }

        }
        Card(
            modifier = Modifier
                .height(100.dp)
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Row (modifier = Modifier
                .background(
                    color = colorResource(R.color.white)
                )
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp), horizontalArrangement = Arrangement.SpaceAround){
                Checkbox(checked =checked, onCheckedChange =onCheckedChange, modifier = Modifier.fillMaxHeight())
                Image(
                    painter = painterResource(R.drawable.smartlock),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(10.dp)
                        .weight(1f)
                )

                Column (modifier = Modifier .weight(1f)){
                    Text(text ="Smart Lock",style = MaterialTheme.typography.bodyLarge,color = if (darkTheme) Color.White else Color.Black  )
                    Text(text = "By Salto",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "Salto XS4 Wall Reader 2",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "Rs.45000",color = if (darkTheme) Color.White else Color.Black )

                }
                Column (modifier = Modifier
                    .padding(2.dp)
                    .weight(1f), horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(Icons.Filled.Favorite, contentDescription = "mail", modifier = Modifier.fillMaxWidth(),
                        Color.Red)
                    Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Pay Now",color = if (darkTheme) Color.White else Color.White )


                    }
                }

            }

        }
    }
}
@Composable
fun MediumToExpendedOrder(){
    val LocalDarkTheme = staticCompositionLocalOf { false }
    val darkTheme = LocalDarkTheme.current
    val (checked,onCheckedChange)= rememberSaveable {
        mutableStateOf(false)
    }

   Column(modifier = Modifier
        .padding(top = 2.dp, end = 2.dp)
        .verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "Ordered Items",color = if (darkTheme) Color.White else Color.White ,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Card(
            modifier = Modifier
                .height(100.dp)
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Row (modifier = Modifier
                .background(
                    color = colorResource(R.color.white)
                )
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp), horizontalArrangement = Arrangement.SpaceAround){
                Checkbox(checked =checked, onCheckedChange =onCheckedChange, modifier = Modifier.fillMaxHeight())
                Image(
                    painter = painterResource(R.drawable.doorhandle),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(10.dp)
                        .weight(1f)
                )

                Column (modifier = Modifier .weight(1f)){
                    Text(text ="Door Handle",style = MaterialTheme.typography.bodyLarge ,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "By AarkayVox",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "AarkayVox Lever Handle",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "Rs.4500",color = if (darkTheme) Color.White else Color.Black )

                }
                Column (modifier = Modifier
                    .padding(2.dp)
                    .weight(1f), horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(Icons.Filled.Favorite, contentDescription = "mail", modifier = Modifier.fillMaxWidth(),
                        Color.Red)
                    Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Pay Now",color = if (darkTheme) Color.White else Color.White )


                    }
                }

            }

        }
        Card(
            modifier = Modifier
                .height(100.dp)
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Row (modifier = Modifier
                .background(
                    color = colorResource(R.color.white)
                )
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp), horizontalArrangement = Arrangement.SpaceAround){
                Checkbox(checked =checked, onCheckedChange =onCheckedChange, modifier = Modifier.fillMaxHeight())
                Image(
                    painter = painterResource(R.drawable.balllcok),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(10.dp)
                        .weight(1f)
                )

                Column (modifier=Modifier .weight(1f)){
                    Text(text ="Ball Handle",style = MaterialTheme.typography.bodyLarge ,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "By Yall",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "Ball Lock 60mm Room",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "Rs.8500",color = if (darkTheme) Color.White else Color.Black )

                }
                Column (modifier = Modifier
                    .padding(2.dp)
                    .weight(1f), horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(Icons.Filled.Favorite, contentDescription = "mail", modifier = Modifier.fillMaxWidth(),
                        Color.Red)
                    Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Pay Now",color = if (darkTheme) Color.White else Color.White )


                    }
                }

            }

        }
        Card(
            modifier = Modifier
                .height(100.dp)
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Row (modifier = Modifier
                .background(
                    color = colorResource(R.color.white)
                )
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp), horizontalArrangement = Arrangement.SpaceAround){
                Checkbox(checked =checked, onCheckedChange =onCheckedChange, modifier = Modifier.fillMaxHeight())
                Image(
                    painter = painterResource(R.drawable.smartlock),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(10.dp)
                        .weight(1f)
                )

                Column (modifier = Modifier .weight(1f)){
                    Text(text ="Smart Lock",style = MaterialTheme.typography.bodyLarge,color = if (darkTheme) Color.White else Color.Black  )
                    Text(text = "By Salto",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "Salto XS4 Wall Reader 2",style = MaterialTheme.typography.bodySmall,color = if (darkTheme) Color.White else Color.Black )
                    Text(text = "Rs.45000",color = if (darkTheme) Color.White else Color.Black )

                }
                Column (modifier = Modifier
                    .padding(2.dp)
                    .weight(1f), horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(Icons.Filled.Favorite, contentDescription = "mail", modifier = Modifier.fillMaxWidth(),
                        Color.Red)
                    Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Pay Now",color = if (darkTheme) Color.White else Color.White )


                    }
                }

            }

        }
    }
}
