package com.example.hardwarestore.Screen

import android.graphics.drawable.Icon
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hardwarestore.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//carusol
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePage(modifier: Modifier = Modifier) {
    // dark theme
    val LocalDarkTheme = staticCompositionLocalOf { false }
    val darkTheme = LocalDarkTheme.current
    Column(modifier=Modifier
        .verticalScroll(rememberScrollState()),) {
        val images = listOf(
            R.drawable.hand1,
            R.drawable.powertool,
            R.drawable.paint,

            )
        val pagerState = rememberPagerState(
            pageCount =
            images.size
        )
        LaunchedEffect(Unit) {
            while (true) {
                delay(3000)
                val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                pagerState.scrollToPage(nextPage)
            }
        }
        val scope = rememberCoroutineScope()
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))
        Column(
            modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = modifier.wrapContentSize()) {
                HorizontalPager(
                    state = pagerState,
                    modifier
                        .wrapContentSize()

                ) { currentPage ->

                    Card(
                        modifier
                            .wrapContentSize()
                            .padding(26.dp),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {

                        Image(
                            painter = painterResource(id = images[currentPage]),
                            contentDescription = "",
                            modifier=Modifier.fillMaxWidth()

                        )

                    }
                }
                IconButton(
                    onClick = {
                        val nextPage = pagerState.currentPage + 1
                        if (nextPage < images.size) {
                            scope.launch {
                                pagerState.scrollToPage(nextPage)
                            }
                        }
                    },
                    modifier
                        .padding(20.dp)
                        .size(48.dp)
                        .align(Alignment.CenterEnd)
                        .clip(CircleShape),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color(0x52373737)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "",
                        modifier.fillMaxSize(),
                        tint = Color.LightGray
                    )
                }
                IconButton(
                    onClick = {
                        val prevPage = pagerState.currentPage -1
                        if (prevPage >= 0) {
                            scope.launch {
                                pagerState.scrollToPage(prevPage)
                            }
                        }
                    },
                    modifier
                        .padding(30.dp)
                        .size(48.dp)
                        .align(Alignment.CenterStart)
                        .clip(CircleShape),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color(0x52373737)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                        modifier.fillMaxSize(),
                        tint = Color.LightGray
                    )
                }
            }

            PageIndicator(
                pageCount = images.size,
                currentPage = pagerState.currentPage,
                modifier = modifier
            )
            //body
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))


        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            Text(text = stringResource(R.string.categories),style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Row (modifier=Modifier,
                verticalAlignment = Alignment.CenterVertically){
                Text(text = stringResource(R.string.seemore),modifier=Modifier.clickable {  } ,style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold )
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Arrow Forward"
                )
            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

        Row(modifier= Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()) ,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically){
            Column(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fastners1),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(20.dp))

                )
                Text(
                    text = stringResource(R.string.fastners),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                )

            }
            Column(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.power1),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Text(
                    text = stringResource(R.string.powertools),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                )

            }
            Column(
                modifier = Modifier .padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.buildingmateriails),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Text(
                    text = stringResource(R.string.buildingitems),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                )

            }
            Column(
                modifier = Modifier .padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.electrical),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Text(
                    text = stringResource(R.string.electricals),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                )

            }
            Column(
                modifier = Modifier .padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plumbing),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Text(
                    text = stringResource(R.string.plumbing),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                )

            }

        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            Text(text = stringResource(R.string.brands),
                style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Row (modifier=Modifier,
                verticalAlignment = Alignment.CenterVertically){
                Text(text = stringResource(R.string.seemore),modifier=Modifier.clickable {  },style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Arrow Forward"
                )
            }

        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        Column(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp) .fillMaxWidth()
            ){
            Image(painter = painterResource(id = R.drawable.stanley), contentDescription ="",modifier= Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth())
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.boshnew), contentDescription ="" ,modifier= Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth())
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.markita), contentDescription ="",modifier= Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth() )



        }

        // new arrivals


        Column(modifier=Modifier .padding(start = 10.dp, end = 20.dp)) {
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            Text(text = stringResource(R.string.newarrivals),style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            Row(modifier=Modifier,
                horizontalArrangement = Arrangement.SpaceAround) {
                Card (modifier= Modifier
                    .padding(2.dp)
                    .weight(1f),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )){
                    Column(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
                        Image(painter = painterResource(id = R.drawable.doorhandle), contentDescription ="",modifier = Modifier.fillMaxWidth())
                        Text(text ="AARKAYVOX",style = MaterialTheme.typography.bodyLarge,color = if (darkTheme) Color.White else Color.Black )
                        Text(text = "AarkayVox Lever Handle - AKVSSMD3941+MD477",style = MaterialTheme.typography.bodyMedium,color = if (darkTheme) Color.White else Color.Black )
                        Image(painter = painterResource(id = R.drawable.rating), contentDescription ="" )
                        Text(text = "Rs.4500",color = if (darkTheme) Color.White else Color.Black )
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                        ) {
                            Text(text = "Buy Now",fontSize = 15.sp,style = MaterialTheme.typography.labelLarge,color = if (darkTheme) Color.White else Color.White )
                        }

                    }

                }
                Card (modifier= Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                    .weight(1f),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )){
                    Column(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
                        Image(painter = painterResource(id = R.drawable.balllcok), contentDescription ="",modifier = Modifier.fillMaxWidth())
                        Text(text ="YALE" ,style = MaterialTheme.typography.bodyLarge,color = if (darkTheme) Color.White else Color.Black  )
                        Text(text = "Bedroom Ball Lock Backset 60/70mm 1",style = MaterialTheme.typography.bodyMedium,color = if (darkTheme) Color.White else Color.Black )
                        Image(painter = painterResource(id = R.drawable.rating), contentDescription ="" )
                        Text(text = "Rs.8500",color = if (darkTheme) Color.White else Color.Black)
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                        ) {
                            Text(text = "Buy Now",fontSize = 15.sp,style = MaterialTheme.typography.labelLarge,color = if (darkTheme) Color.White else Color.White )
                        }

                    }

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier=Modifier,
                horizontalArrangement = Arrangement.SpaceAround) {
                Card (modifier= Modifier
                    .padding(2.dp)
                    .weight(1f)
                    .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )){
                    Column(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
                        Image(painter = painterResource(id = R.drawable.wallrack), contentDescription ="",modifier = Modifier.fillMaxWidth())
                        Text(text ="MCOCO",style = MaterialTheme.typography.bodyLarge,color = if (darkTheme) Color.White else Color.Black)
                        Text(text = "Mcoco DIY Bathroom Towel Rail Holder",style = MaterialTheme.typography.bodyMedium,color = if (darkTheme) Color.White else Color.Black)
                        Image(painter = painterResource(id = R.drawable.rating), contentDescription ="" )
                        Text(text = "Rs.12500",color = if (darkTheme) Color.White else Color.Black)
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                            modifier = Modifier
                                .fillMaxWidth()


                        ) {
                            Text(text = "Buy Now",fontSize = 15.sp,style = MaterialTheme.typography.labelLarge,color = if (darkTheme) Color.White else Color.White)
                        }

                    }

                }
                Card (modifier= Modifier
                    .padding(2.dp)
                    .fillMaxWidth()
                    .weight(1f),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )){
                    Column(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
                        Image(painter = painterResource(id = R.drawable.smartlock), contentDescription ="",modifier = Modifier.fillMaxWidth())
                        Text(text ="SALTO" ,color = if (darkTheme) Color.White else Color.Black)
                        Text(text = "Salto XS4 Wall Reader 2.0",style = MaterialTheme.typography.bodyMedium,color = if (darkTheme) Color.White else Color.Black)
                        Image(painter = painterResource(id = R.drawable.rating), contentDescription ="" )
                        Text(text = "Rs.45000",color = if (darkTheme) Color.White else Color.Black)

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)

                        ) {
                            Text(text = "Buy Now",fontSize = 15.sp,style = MaterialTheme.typography.labelLarge,color = if (darkTheme) Color.White else Color.White)
                        }



                    }

                }

            }


        }
        Spacer(modifier = Modifier.height(100.dp))


    }



}



@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(pageCount){
            IndicatorDots(isSelected = it == currentPage, modifier= modifier)
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier) {
    val size = animateDpAsState(targetValue = if (isSelected) 12.dp else 10.dp, label = "")
    Box(modifier = modifier
        .padding(2.dp)
        .size(size.value)
        .clip(CircleShape)
        .background(if (isSelected) Color(0xff373737) else Color(0xA8373737))
    )
}




