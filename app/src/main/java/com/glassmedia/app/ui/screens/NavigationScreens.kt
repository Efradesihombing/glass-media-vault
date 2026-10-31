package com.glassmedia.app.ui.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class BottomNavItem(val label: String) {
    Home("Home"),
    Library("Library"),
    Discover("Discover"),
    Profile("Profile")
}

@Composable
fun ModernBottomNav(
    selected: BottomNavItem,
    onSelect: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem.Home to Icons.Default.Home,
        BottomNavItem.Library to Icons.Default.LibraryMusic,
        BottomNavItem.Discover to Icons.Default.Search,
        BottomNavItem.Profile to Icons.Default.Person
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xCC101B2B))
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEach { (item, icon) ->
                val isSelected = item == selected
                val iconScale by animateFloatAsState(
                    targetValue = if (isSelected) 1.08f else 1f,
                    animationSpec = tween(220)
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(58.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(
                            if (isSelected) {
                                Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFF7C8CFF),
                                        Color(0xFF5BD1FF)
                                    )
                                )
                            } else {
                                Color.Transparent
                            }
                        )
                        .clickable { onSelect(item) },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = item.label,
                            tint = if (isSelected) Color.White else Color(0xFFB9C7DA),
                            modifier = Modifier
                                .size(22.dp)
                                .scale(iconScale)
                        )

                        if (isSelected) {
                            Text(
                                text = item.label,
                                color = Color.White,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
"""},{