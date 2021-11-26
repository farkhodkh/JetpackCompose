package com.example.jetpackcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R

private val openSans = FontFamily(
    Font(R.font.open_sans_regular),
    Font(R.font.open_sans_bold, FontWeight.Bold),
    Font(R.font.open_sans_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.open_sans_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.open_sans_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.open_sans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.open_sans_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.open_sans_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.open_sans_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.open_sans_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
)

/**
 * Typography definition.
 */
internal val Typography = Typography(
    defaultFontFamily = openSans,
    h3 = TextStyle(
        fontFamily = openSans,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold
    ),
    h5 = TextStyle(
        fontFamily = openSans,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    h6 = TextStyle(
        fontFamily = openSans,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    ),
    body1 = TextStyle(
        fontFamily = openSans,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold
    ),
    body2 = TextStyle(
        fontFamily = openSans,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    caption = TextStyle(
        fontFamily = openSans,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = MoreColors.CaptionText
    ),
    button = TextStyle(
        fontFamily = openSans,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
    ),
)