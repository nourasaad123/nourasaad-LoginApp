package com.example.mylogininscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.style.TextAlign

//package com.example.mylogininscreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.core.graphics.ColorUtils
import androidx.navigation.NavController
import com.example.mylogininscreen.composescroll.persons
import com.example.mylogininscreen.ui.theme.MyLoginInScreenTheme

@Composable
fun NavigateParameter(
    navController: NavController,
    fname: String,
    lname: String,
    age: Int,
    email: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .size(200.dp)
            .padding(8.dp)
            .background(Color.White)
            .clip(
                RoundedCornerShape(50.dp)
            ), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Surface(
            modifier = Modifier.size(200.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.woman),
                contentDescription = null, modifier = Modifier.size(100.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(10.dp), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Name : $fname $lname ",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(10.dp))


            Text(
                text = "Age : $age ",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "Email : $email",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PeriviewCard() {
    MyLoginInScreenTheme {

    }
}



