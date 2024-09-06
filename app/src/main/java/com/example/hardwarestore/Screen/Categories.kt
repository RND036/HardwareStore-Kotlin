package com.example.hardwarestore.Screen

import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.hardwarestore.R

@Composable
fun Categories(){
    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))
    Column (modifier = Modifier
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Text(
            text = stringResource(R.string.categories),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(8.dp)
        )
        Card(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Box (modifier = Modifier.height(200.dp)){
                Image(painter = painterResource(R.drawable.hand), contentDescription ="", contentScale = ContentScale.Crop, modifier = Modifier .blur(radius = 1.dp) .fillMaxWidth() )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    ))
                Box(modifier = Modifier .fillMaxSize(),
                    contentAlignment = Alignment.Center){
                    Text(text = stringResource(R.string.handtools), color = colorResource(id = R.color.white), style =  MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)

                }
            }

        }
        Card(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box (modifier = Modifier.height(200.dp)){
                Image(painter = painterResource(R.drawable.power), contentDescription ="", contentScale = ContentScale.Crop,modifier = Modifier .blur(radius = 1.dp).fillMaxWidth() )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    ))
                Box(modifier = Modifier .fillMaxSize(),
                    contentAlignment = Alignment.Center){
                    Text(text = stringResource(R.string.powertools),color = colorResource(id = R.color.white), style =  MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)

                }
            }

        }
        Card(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box (modifier = Modifier.height(200.dp)){
                Image(painter = painterResource(R.drawable.paints2), contentDescription ="", contentScale = ContentScale.Crop,modifier = Modifier .blur(radius = 1.dp).fillMaxWidth() )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    ))
                Box(modifier = Modifier .fillMaxSize(),
                    contentAlignment = Alignment.Center){
                    Text(text = stringResource(R.string.paints),color = colorResource(id = R.color.white), style =  MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)

                }
            }

        }
        Card(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box (modifier = Modifier.height(200.dp)){
                Image(painter = painterResource(R.drawable.plumbing), contentDescription ="", contentScale = ContentScale.Crop,modifier = Modifier .blur(radius = 1.dp) .fillMaxWidth())
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    ))
                Box(modifier = Modifier .fillMaxSize(),
                    contentAlignment = Alignment.Center){
                    Text(text = stringResource(R.string.plumbing), color = colorResource(id = R.color.white), style =  MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)

                }
            }

        }
        Card(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box (modifier = Modifier.height(200.dp)){
                Image(painter = painterResource(R.drawable.building), contentDescription ="", contentScale = ContentScale.Crop,modifier = Modifier .blur(radius = 1.dp) .fillMaxWidth())
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    ))
                Box(modifier = Modifier .fillMaxSize(),
                    contentAlignment = Alignment.Center){
                    Text(text = stringResource(R.string.buildingitems), color = colorResource(id = R.color.white), style =  MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)

                }
            }
            Spacer(modifier = Modifier.height(70.dp))

        }



    }
}