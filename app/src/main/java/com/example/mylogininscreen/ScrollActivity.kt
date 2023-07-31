package com.example.mylogininscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mylogininscreen.ui.theme.MyLoginInScreenTheme

class ScrollActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginInScreenTheme {
                // A surface container using the 'background' color from the theme

                   MyCard()

            }
        }
    }
}
@Composable
fun MyCard() {

Row(modifier = Modifier
    .padding(8.dp)
    .clip(
        RoundedCornerShape(4.dp)
    )
    .background(color = Color.Black)
    .padding(16.dp)) {
Surface(modifier = Modifier.size(50.dp),
shape= CircleShape,
color=MaterialTheme.colorScheme.onSurface.copy(alpha=0.4f)
) {
Image(painter =R.drawable.man, contentDescription ="" )
}
}







}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
        MyCard()

}