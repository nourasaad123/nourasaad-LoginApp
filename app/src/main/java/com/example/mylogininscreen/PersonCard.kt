package com.example.mylogininscreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mylogininscreen.composescroll.persons
import com.example.mylogininscreen.ui.theme.MyLoginInScreenTheme

@Composable
fun PersonCard (imageRes:Int,name:String,job:String) {
        Row(
            modifier = Modifier
                .padding(8.dp).fillMaxWidth()
                .clip(
                    RoundedCornerShape(50.dp)
                )
                .background(color = Color.DarkGray)
                .padding(16.dp)
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
            ) {
                Image(painter = painterResource(id = imageRes), contentDescription = null)
            }
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = name, fontWeight = FontWeight.Bold, color = Color.White)
                Text(
                    text = job,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }

        }
    }


@Preview(showBackground = true)
@Composable
fun PeriviewGreatCard(){
    MyLoginInScreenTheme {
      PersonCard(imageRes = persons[1].imageRes,name=persons[1].name ,job =persons[1].job)
    }
}



