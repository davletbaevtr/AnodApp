package com.example.anod_compose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import com.example.anod_compose.R

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.font1)),
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 50.sp,
        letterSpacing = 0.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.font1)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.font1)),
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),

    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.font1)),
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.font1)),
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    )
)