package app.imran.passwordmanager.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// primary — The primary color is the color displayed most frequently across your app’s screens and components.
// primaryVariant — The primary variant color is used to distinguish two elements of the app using the primary color, such as the top app bar and the system bar.
// secondary — The secondary color provides more ways to accent and distinguish your product. Secondary colors are best for floating action buttons, selection controls (e.g. checkboxes and radio buttons), highlighting selected text, links, and headlines, etc.
// secondaryVariant — The secondary variant color is used to distinguish two elements of the app using the secondary color.
// background — The background color appears behind scrollable content.
// surface — The surface color is used on surfaces of components, such as cards, sheets, and menus.
// error — The error color is used to indicate errors within components, such as text fields.
// onPrimary — Color used for text and icons displayed on top of the primary color.
// onSecondary — Color used for text and icons displayed on top of the secondary color.
// onBackground — Color used for text and icons displayed on top of the background color.
// onSurface — Color used for text and icons displayed on top of the surface color.
// onError — Color used for text and icons displayed on top of the error color.
// isLight — Whether these colors are considered as a “light” or “dark” set of colors.

private val DarkColorPalette = darkColors(
    primary = AppGreen,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = Color.Black,
    onSurface = Color.White,
    background = Color.Black,
    onBackground = Color.White,

)

private val LightColorPalette = lightColors(
    primary = AppGreen,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = Color.White,
    onSurface = Color.Black,
    background = Color.White,
    onBackground = Color.Black,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AndroidPasswordManagerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
