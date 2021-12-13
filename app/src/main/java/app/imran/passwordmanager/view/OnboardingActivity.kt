package app.imran.passwordmanager.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
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
import app.imran.passwordmanager.ui.theme.Typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

class OnboardingActivity : ComponentActivity() {

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        setContent {
            AndroidPasswordManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val items = getItems()

                    OnBoardingPager(items, rememberPagerState(), modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }

    private fun getItems(): ArrayList<OnboardingData> {
        val items = ArrayList<OnboardingData>()
        items.add(OnboardingData(R.drawable.screen_neverforget, "Never forget any Password"))
        items.add(OnboardingData(R.drawable.screen_security, "All Data's are Encrypted"))
        items.add(OnboardingData(R.drawable.screen_saveall, "Bring all your passwords under one roof"))

        return items
    }

    @ExperimentalPagerApi
    @Composable
    fun OnBoardingPager(
        item: ArrayList<OnboardingData>,
        pagerState: PagerState,
        modifier: Modifier = Modifier
    ) {
        Box(modifier = modifier) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                            color = Color.Black,
                            style = Typography.caption,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                PagerIndicator(size = item.size, currentPage = pagerState.currentPage)
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
                    if (isSelected) Color.Red else Color.Gray.copy(alpha = 0.5f)
                )
        )
    }
//
//    @Composable
//    fun setButtons() {
//        Row(modifier = Modifier.padding(top = 20.dp).fillMaxWidth()) {
//
//
//        }
//    }
}
