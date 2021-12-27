package app.imran.passwordmanager.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.imran.passwordmanager.ui.components.AppButton
import app.imran.passwordmanager.ui.components.AppButtonInterface
import app.imran.passwordmanager.ui.theme.AndroidPasswordManagerTheme
import app.imran.passwordmanager.ui.theme.Typography

class AuthenticationActivity : ComponentActivity(),AppButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPasswordManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginUI()
                }
            }
        }
    }




@Preview
@Composable
fun LoginUI() {

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        ) {

        Text(text = "Verify your phone number", modifier = Modifier.padding(top = 100.dp, start = 25.dp,end=25.dp),style = Typography.h3)
        Text(text = "", modifier = Modifier.padding(top = 20.dp, start = 25.dp,end=25.dp),style = Typography.h6)


        AppButton( text = "Get Started", listener = this@AuthenticationActivity , enabled = true, modifier = Modifier)
    }
}

    override fun onButtonClicked() {
        TODO("Not yet implemented")
    }

}