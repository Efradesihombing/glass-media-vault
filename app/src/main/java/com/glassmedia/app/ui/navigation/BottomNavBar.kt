package com.glassmedia.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.glassmedia.app.ui.navigation.BottomNavItem
import com.glassmedia.app.ui.navigation.ModernBottomNav
import com.glassmedia.app.ui.screens.DiscoverScreen
import com.glassmedia.app.ui.screens.HomeScreen
import com.glassmedia.app.ui.screens.LibraryScreen
import com.glassmedia.app.ui.screens.ProfileScreen
import com.glassmedia.app.ui.theme.GlassMediaVaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlassMediaVaultTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GlassMediaVaultApp()
                }
            }
        }
    }
}

@Composable
fun GlassMediaVaultApp() {
    var selectedTab by remember { mutableStateOf(BottomNavItem.Home) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF09111F),
                        Color(0xFF111A2B),
                        Color(0xFF1D2B45)
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 96.dp)
        ) {
            when (selectedTab) {
                BottomNavItem.Home -> HomeScreen()
                BottomNavItem.Library -> LibraryScreen()
                BottomNavItem.Discover -> DiscoverScreen()
                BottomNavItem.Profile -> ProfileScreen()
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            ModernBottomNav(
                selected = selectedTab,
                onSelect = { selectedTab = it }
            )
        }
    }
}
