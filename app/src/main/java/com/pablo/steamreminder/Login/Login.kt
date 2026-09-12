package com.pablo.steamreminder.Login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pablo.steamreminder.R
import androidx.core.net.toUri


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        enableEdgeToEdge()
//        setContent {
//            LoginScreen()
//        }
        intent.data
    }
}

@Preview
@Composable
fun LoginScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD3D2D6))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(R.drawable.steam),
            contentDescription = "Steam logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
//                .padding(5.dp)
                .border(4.dp, Color.Black, shape = CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Faça o seu login",
            fontSize = 32.sp,
            color = Color(0xFF353535),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text (
            text = "Entre com a Steam para continuar",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF757575)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = Modifier.clickable(onClick = {
                    invokeIntent(context)
                })
                    .width(94.dp)
                    .height(50.dp),
                painter = painterResource(R.drawable.steam_login),
                contentDescription = "Logar com a Steam",
                contentScale = ContentScale.FillBounds
            )

        }

    }
}

private fun invokeIntent(context: Context) {
    val customTabsIntent =
        CustomTabsIntent.Builder().build()

    customTabsIntent.launchUrl(
        context,
        "https://steam-reminder-api-6944.steam-reminder-api.proxy.w8hub.com.br/".toUri()
    )
}

private fun teste() {
}