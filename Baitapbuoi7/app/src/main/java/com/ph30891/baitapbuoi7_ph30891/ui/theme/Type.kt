package com.ph30891.baitapbuoi7_ph30891.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ph30891.baitapbuoi7_ph30891.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
val Gelasio = FontFamily(
    Font(R.font.gelasio_gegular,FontWeight.Medium),
    Font(R.font.gelasio_bold,FontWeight.Bold),
    Font(R.font.gelasio_semi_bold, FontWeight.SemiBold)
)
val Merriweather = FontFamily(
    Font(R.font.merriweather_bold,FontWeight.Bold),
    Font(R.font.merriweather_regular,FontWeight.Medium)
)
val Nunito_Sans = FontFamily(
    Font(R.font.nunito_sans_10pt_regular,FontWeight.Medium),
    Font(R.font.nunito_sans_10pt_bold,FontWeight.Bold),
    Font(R.font.nunito_sans_10pt_semi_bold, FontWeight.SemiBold)
)