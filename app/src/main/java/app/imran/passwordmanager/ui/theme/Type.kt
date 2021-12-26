package app.imran.passwordmanager.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.*
import androidx.compose.ui.unit.sp
import app.imran.passwordmanager.R

val fonts = FontFamily(
    Font(R.font.sourcesanspro_bold, FontWeight.Bold),
    Font(R.font.sourcesanspro_light, FontWeight.Light),
    Font(R.font.sourcesanspro_italic, FontWeight.Companion.ExtraLight),
    Font(R.font.sourcesanspro_regular, FontWeight.Normal),
    Font(R.font.sourcesanspro_semibold, FontWeight.SemiBold)
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )

)
