package com.example.hardwarestore.Screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.SettingsPower
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Support
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ContentAlpha
import com.example.hardwarestore.R

@Composable
fun Settings(darkTheme: Boolean, onThemeUpdated: () -> Unit){
    //dark theme
    val LocalDarkTheme = staticCompositionLocalOf { false }

    val darkTheme = LocalDarkTheme.current
Row(modifier = Modifier.verticalScroll(rememberScrollState()),
    horizontalArrangement = Arrangement.SpaceEvenly,
    verticalAlignment = Alignment.Top) {
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(70.dp))
        Card (shape = CircleShape){
            Image(painter = painterResource(R.drawable.man), contentDescription ="", modifier = Modifier)

        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Text(text = "Ravishka Dissanayaka",style = MaterialTheme.typography.titleLarge)
        Text(text = "0781827743",style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Card(modifier = Modifier
            .fillMaxWidth()
            .size(50.dp),colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
                )) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Dark Mode",style = MaterialTheme.typography.titleLarge)
                ThemeSwitcher(
                    darkTheme = darkTheme,
                    onClick = onThemeUpdated
                )
            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Card(modifier = Modifier.fillMaxWidth(),colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
                )) {
            val checkedState = remember {
                mutableStateOf(false)
            }
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Notifications",style = MaterialTheme.typography.titleLarge)
                Switch(checked =checkedState.value , onCheckedChange = {checkedState.value=it}, modifier = Modifier)

            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        ExpandableCard(
            title = "Account Settings",
            description1 = "Account Information",
            description2 ="Profile Settings" ,
            description3 ="Manage Security" ,
            description4 = "Preferences"
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        ExpandableCard(
            title = "General Settings",
            description1 ="CheckOut Method" ,
            description2 ="Order History" ,
            description3 = "Order Address",
            description4 ="Analytics"
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Card (modifier = Modifier.fillMaxWidth() .size(50.dp),colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
                )){
            Row {
                Icon(imageVector = Icons.Default.Security, contentDescription = "", modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))
                Text(text = "Security and Privacy Policy",style = MaterialTheme.typography.titleLarge,  modifier = Modifier.clickable {  })

            }

        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Card (modifier = Modifier.fillMaxWidth(),colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )){
            Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Icon(imageVector = Icons.Default.Support, contentDescription = "",modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))
                Text(text = "Support and Feedback",style = MaterialTheme.typography.titleLarge, modifier = Modifier.clickable {  })
            }

        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Card (modifier = Modifier.fillMaxWidth(),colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )){
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Log Out", modifier = Modifier.weight(6f),style = MaterialTheme.typography.titleLarge)
                androidx.compose.material3.Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Red),
                ) {
                 androidx.compose.material3.Icon(imageVector = Icons.Default.PowerSettingsNew, contentDescription = "", tint = if (darkTheme) Color.White else Color.White)
                }

            }


        }
        Spacer(modifier = Modifier.height(10.dp))

        Row (verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center){
            Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Tech.",style = MaterialTheme.typography.bodyLarge,)
                Text(text = "Version 1.0.0",style = MaterialTheme.typography.bodyMedium,)
                Text(text = "Powered By 4GBx Solutions",style = MaterialTheme.typography.bodySmall,)
            }


        }



    }


}

}
// dark theme toggler
@Composable
fun ThemeSwitcher(
    darkTheme: Boolean = false,
    size: Dp = 40.dp,
    iconSize: Dp = size / 3,
    padding: Dp = 10.dp,
    borderWidth: Dp = 1.dp,
    parentShape: Shape = CircleShape,
    toggleShape: Shape = CircleShape,
    animationSpec: AnimationSpec<Dp> = tween(durationMillis = 300),
    onClick: () -> Unit
) {
    val offset by animateDpAsState(
        targetValue = if (darkTheme) 0.dp else size,
        animationSpec = animationSpec
    )

    Box(modifier = Modifier
        .width(size * 2)
        .height(size)
        .clip(shape = parentShape)
        .clickable { onClick() }
        .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .offset(x = offset)
                .padding(all = padding)
                .clip(shape = toggleShape)
                .background(MaterialTheme.colorScheme.primary)
        )
        Row(
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = borderWidth,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    shape = parentShape
                )
        ) {
            Box(
                modifier = Modifier.size(size),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(iconSize),
                    imageVector = Icons.Default.Nightlight,
                    contentDescription = "Theme Icon",
                    tint = if (darkTheme) MaterialTheme.colorScheme.secondaryContainer
                    else MaterialTheme.colorScheme.primary
                )
            }
            Box(
                modifier = Modifier.size(size),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(iconSize),
                    imageVector = Icons.Default.LightMode,
                    contentDescription = "Theme Icon",
                    tint = if (darkTheme) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.secondaryContainer
                )
            }
        }
    }
}

//expandble card
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(
    title:String,
    description1:String,
    description2:String,
    description3:String,
    description4:String,
    titleFontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    descriptionFontSize: TextUnit = MaterialTheme.typography.bodyLarge.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines: Int = 4,
    shape: Shape = RoundedCornerShape(4.dp),
    padding: Dp = 12.dp
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier

            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = shape,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    fontSize = titleFontSize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            if (expandedState) {
                Column (modifier = Modifier, verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.Start){

                        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text =description1,
                                fontSize = descriptionFontSize,
                                maxLines = descriptionMaxLines,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .clickable {}
                                    .weight(6f)
                            )
                            IconButton(
                                modifier = Modifier
                                    .weight(1f),

                                onClick = {

                                }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                    contentDescription = ""
                                )
                            }



                    }
                    Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically){
                        Text(
                            text =description2,
                            fontSize = descriptionFontSize,
                            maxLines = descriptionMaxLines,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .clickable {}
                                .weight(6f)
                        )
                        IconButton(
                            modifier = Modifier
                                .weight(1f),

                            onClick = {
                            }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                contentDescription = ""
                            )
                        }
                    }
                    Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically){
                        Text(
                            text =description3,
                            fontSize = descriptionFontSize,
                            maxLines = descriptionMaxLines,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .clickable {}
                                .weight(6f)

                        )
                        IconButton(
                            modifier = Modifier
                                .weight(1f),


                            onClick = {
                            }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                contentDescription = ""
                            )
                        }
                    }


                    Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically){
                        Text(
                            text =description4,
                            fontSize = descriptionFontSize,
                            maxLines = descriptionMaxLines,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .clickable { }
                                .weight(6f)
                        )
                        IconButton(
                            modifier = Modifier
                                .weight(1f),

                            onClick = {
                            }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                contentDescription = ""

                            )
                        }
                    }

                }


            }
        }
    }
}