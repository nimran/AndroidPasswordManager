package app.imran.passwordmanager.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import app.imran.passwordmanager.R
import app.imran.passwordmanager.data.OnboardingData
import app.imran.passwordmanager.ui.theme.AndroidPasswordManagerTheme
import app.imran.passwordmanager.ui.theme.AppGreen
import app.imran.passwordmanager.ui.theme.Typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

class OnboardingActivity : ComponentActivity() {

    lateinit var items: ArrayList<OnboardingData>

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
//        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        setContent {
            AndroidPasswordManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface() {
                    items = getOnboardingItems()

                    OnBoardingPager(items, rememberPagerState(), modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }

    private fun getOnboardingItems(): ArrayList<OnboardingData> {
        val items = ArrayList<OnboardingData>()
        items.add(OnboardingData(R.drawable.screen_neverforget, "Never forget any Password"))
        items.add(OnboardingData(R.drawable.screen_security, "All Data's are Encrypted"))
        items.add(OnboardingData(R.drawable.screen_saveall, "Bring all your passwords under one roof"))

        return items
    }

    @Composable
    fun SkipButton() {
        TextButton(
            onClick = {
                startActivity(Intent(this@OnboardingActivity, AuthenticationActivity::class.java))
                finish()
            },
            enabled = true
        ) {
            Text(color = Color.Red.copy(), text = "Skip")
        }
    }

    @ExperimentalPagerApi
    @Composable
    fun OnBoardingPager(
        item: ArrayList<OnboardingData>,
        pagerState: PagerState,
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier = modifier
                .fillMaxHeight()
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                SkipButton()
                HorizontalPager(count = item.size, state = pagerState) { page ->
                    Column(
                        modifier = Modifier
                            .padding(top = 60.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = item[page].image),
                            contentDescription = item[page].desc,
                            modifier = Modifier
                                .height(400.dp)
                                .fillMaxWidth()
                        )
                        Text(
                            text = item[page].desc,
                            modifier = Modifier.padding(top = 50.dp, start = 20.dp, end = 20.dp),
                            color = MaterialTheme.colors.primary,
                            style = Typography.body2,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                PagerIndicator(size = item.size, currentPage = pagerState.currentPage)
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp)
            ) {
                SetButtons(pagerState)
            }
        }
    }

    @Composable
    fun PagerIndicator(size: Int, currentPage: Int) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 60.dp)
        ) {
            repeat(size) {
                Indicator(isSelected = it === currentPage)
            }
        }
    }

    @Composable
    fun Indicator(isSelected: Boolean) {
        val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

        Box(
            modifier = Modifier
                .padding(1.dp)
                .height(10.dp)
                .width(width.value)
                .clip(CircleShape)
                .background(
                    if (isSelected) AppGreen else Color.Gray.copy(alpha = 0.5f)
                )
        )
    }

    @ExperimentalPagerApi
    @Composable
    fun SetButtons(pagerState: PagerState) {
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Button(
                onClick = {
                    startActivity(Intent(this@OnboardingActivity, AuthenticationActivity::class.java))
                    finish()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AppGreen,
                    disabledBackgroundColor = AppGreen
                        .copy(alpha = 0.2f)
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier.fillMaxWidth(),
                enabled = pagerState.currentPage == items.size - 1,
            ) {
                Text(style = Typography.body2, text = "Get Started")
            }
        }
    }
}
