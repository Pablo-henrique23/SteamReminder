package com.pablo.steamreminder.Game

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun GameCard(img: Int, name: String, price: Float, discount: Float = 0f, description: String = ""){
    var isExpanded by remember { mutableStateOf(false) }
    var nameAndPrice: String
    val backgroundColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary
    )

    if (discount > 0) {
        val discountedPrice = price*(1-discount)
        nameAndPrice = "$name\nR$${price} --> R$${"%.2f".format(discountedPrice)}"
    } else nameAndPrice = "$name\nR$${price}"

    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 0.dp)
    ){
        Row(
            modifier = Modifier
                .background(backgroundColor)
                .fillMaxWidth()
                .padding(5.dp)
                .clickable { isExpanded = !isExpanded },
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Image(
                painter = painterResource(img),
                contentDescription = "Game's thumb",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(70.dp)
            )
            LazyColumn(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.animateContentSize(),

                ) {
                item {
                    Text(
                        text = nameAndPrice,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
                item {
                    Text(
                        text = description,
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        color = MaterialTheme.colorScheme.tertiary,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
        }
    }
}
