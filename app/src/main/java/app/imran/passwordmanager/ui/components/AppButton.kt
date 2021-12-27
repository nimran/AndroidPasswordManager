package app.imran.passwordmanager.ui.components

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.imran.passwordmanager.ui.theme.AppGreen
import app.imran.passwordmanager.ui.theme.Typography
import app.imran.passwordmanager.view.activity.AuthenticationActivity


interface AppButtonInterface {
    fun onButtonClicked()
}

@Composable
fun AppButton(text : String, listener: AppButtonInterface, modifier: Modifier = Modifier,enabled:Boolean) {
    Row(
        modifier = modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = {
                listener.onButtonClicked()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = AppGreen,
                disabledBackgroundColor = AppGreen
                    .copy(alpha = 0.2f)
            ),
            shape = RoundedCornerShape(50),
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
        ) {
            Text(style = Typography.body2, text = text)
        }
    }

}