package com.pablo.steamreminder

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pablo.steamreminder.ui.theme.SteamReminderTheme
import com.pablo.steamreminder.Game.Game
import com.pablo.steamreminder.Game.GameCard
import com.pablo.steamreminder.Login.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SteamReminderTheme(
                darkTheme = true,
                dynamicColor = false
            ) {
                LoginScreen()

//                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
//                    MainScreen(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
        intent?.data?.let {
            Log.d("STEAM", it.toString())
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val spaceMarines = Game(
        img = R.drawable.spacemarines,
        name = "Warhammer 40,000: Space Marine 2",
        price = 99.99f,
        discount = 0.5f,
        description = "Space marine 2 é um jogo grande blablablabla bla bla bla Warhammer 40.000 blablablablablablablablablablablabla"
    )

    val games = listOf(
        spaceMarines,
        spaceMarines,
        spaceMarines,
        spaceMarines,
        spaceMarines,
        spaceMarines,
    )

    Surface(modifier = modifier.fillMaxSize()) {
        Column (
            modifier = Modifier.padding(horizontal = 5.dp, vertical = 0.dp)
        ){
            games.forEach {
                Spacer(modifier = Modifier.height(14.dp))
                GameCard(it.img, it.name, it.price, it.discount, it.description)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    SteamReminderTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
//        Login()
    }
}

