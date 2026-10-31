package com.glassmedia.app.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MediaItem(
    val title: String,
    val subtitle: String,
    val color: Color
)

@Composable
fun HomeScreen() {
    val recentMedia = listOf(
        MediaItem("Mix Night", "Mood", Color(0xFF7C8CFF)),
        MediaItem("Sunset", "Daily", Color(0xFF5BD1FF)),
        MediaItem("Night Drive", "Favorite", Color(0xFFB07CFF))
    )

    val favorites = listOf(
        MediaItem("Album", "12 videos", Color(0xFF6EE7B7)),
        MediaItem("Shorts", "27 clips", Color(0xFFFDCC6F)),
        MediaItem("Travel", "4 trips", Color(0xFFEA7BD0))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF09111F),
                        Color(0xFF111A2B),
                        Color(0xFF17253C)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 18.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Good evening",
                        color = Color(0xFFB9C7DA),
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Glass Media Vault",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Surface(
                    modifier = Modifier.size(44.dp),
                    color = Color(0x40FFFFFF),
                    shape = CircleShape
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    }
                }
            }

            // Search bar pill
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                color = Color(0x30FFFFFF),
                shape = RoundedCornerShape(22.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color(0xFFE7EEFF)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Search media, albums, favorites",
                        color = Color(0xFFCBD9F5),
                        fontSize = 14.sp
                    )
                }
            }

            // Quick category chips
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                GlassChip("Recent")
                GlassChip("Videos")
                GlassChip("Photos")
                GlassChip("Favorites")
            }

            SectionHeader("Recent")
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(recentMedia) { item ->
                    MediaCard(item)
                }
            }

            SectionHeader("Collections")
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(favorites) { item ->
                    MediaCard(item, isLarge = true)
                }
            }

            SectionHeader("Favorites")
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FavoriteRow("Travel memories", "14 items", Color(0xFF90CAF9))
                FavoriteRow("Daily notes", "7 items", Color(0xFF80CBC4))
                FavoriteRow("Short clips", "20 clips", Color(0xFFB39DDB))
            }
        }
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
private fun GlassChip(text: String) {
    Surface(
        color = Color(0x22FFFFFF),
        shape = RoundedCornerShape(18.dp)
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 9.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun MediaCard(item: MediaItem, isLarge: Boolean = false) {
    val width = if (isLarge) 180.dp else 160.dp
    val height = if (isLarge) 170.dp else 150.dp

    Surface(
        modifier = Modifier
            .width(width)
            .height(height),
        color = Color(0x32FFFFFF),
        shape = RoundedCornerShape(28.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            item.color.copy(alpha = 0.8f),
                            Color(0xFF101B2B)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = item.subtitle,
                    color = Color(0xFFDEEBFF),
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
private fun FavoriteRow(title: String, subtitle: String, accent: Color) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0x26FFFFFF),
        shape = RoundedCornerShape(22.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(accent)
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column {
                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = subtitle,
                    color = Color(0xFFB9C7DA),
                    fontSize = 12.sp
                )
            }
        }
    }
}
