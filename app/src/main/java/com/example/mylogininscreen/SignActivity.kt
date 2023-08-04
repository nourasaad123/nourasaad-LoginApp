package com.example.mylogininscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.mylogininscreen.ui.theme.MyLoginInScreenTheme
import java.nio.file.WatchEvent

class SignActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginInScreenTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {

             //       Greeting( )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Greeting(navController: NavController) {
    val textValue = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val textName = remember {
        mutableStateOf("")
    }
    val textage = remember {
        mutableStateOf("")
    }
    val textemail = remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(R.string.create_an_account), modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .size(50.dp),
            fontSize = 30.sp, textAlign = TextAlign.Center
        )
        OutlinedTextField(value = textValue.value,
            onValueChange = { textValue.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default,
            label = { Text(text = stringResource(R.string.fist_name), fontSize = 20.sp) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = ""
                )
            }
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(value = textName.value,
            onValueChange = { textName.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default,
            label = { Text(text = stringResource(R.string.last_name), fontSize = 20.sp) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = ""
                )
            }
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(value = textage.value,
            onValueChange = { textage.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default,
            label = { Text(text = stringResource(R.string.age), fontSize = 20.sp) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_av_timer_24),
                    contentDescription = ""
                )
            }

        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(value = textemail.value,
            onValueChange = { textemail.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default,
            label = { Text(text = stringResource(R.string.email), fontSize = 20.sp) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    contentDescription = ""
                )
            }
        )
        Spacer(modifier = Modifier.height(6.dp))

Column(modifier=Modifier.fillMaxSize().padding(20.dp),

    horizontalAlignment =Alignment.CenterHorizontally ) {

    Button(onClick = {navController.navigate("profilescreen/${textValue.value}&${textName.value}&${textage.value}&${textemail.value}")},

    ) {
        Text(text = stringResource(R.string.register), color = Color.White, fontSize = 25.sp)
    }
}







    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    MyLoginInScreenTheme {
    }
}