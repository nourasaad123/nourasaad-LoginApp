package com.example.mylogininscreen

//import androidx.compose.foundation.layout.RowScopeInstance.weight
//import androidx.compose.foundation.layout.RowScopeInstance.weight
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylogininscreen.ui.theme.MyLoginInScreenTheme
import java.nio.file.WatchEvent
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginInScreenTheme {
                // A surface container using the 'background' color from the theme
                LogininScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun LogininScreen() {
   var username by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    val checkedState by remember{ mutableStateOf(true) }
    val (focusUsername,focusPssword)= remember {FocusRequester.createRefs()}
    val keyboardController=LocalSoftwareKeyboardController.current
    var isPasswordVisiable by remember { mutableStateOf(false) }
    Scaffold() {
    Column(
        modifier=Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween
    ){
Box(modifier= Modifier
    .fillMaxWidth()
    .fillMaxHeight(fraction = 0.30f),Alignment.TopEnd){
   Image(painter = painterResource(id = R.drawable.baseline_login_24), contentDescription ="",
modifier=Modifier.fillMaxSize(),contentScale= ContentScale.FillBounds,
   colorFilter= ColorFilter.tint(Color.White)
       )
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(horizontal = 20.dp, vertical = 50.dp),
        verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
Image(painter= painterResource(id = R.drawable.baseline_login_24),contentDescription="logo",
modifier= Modifier
    .weight(1f)
    .size(100.dp)
    )
        Text(text = "Welcome",fontSize=50.sp)
    }
}
        Column(
          modifier= Modifier
              .fillMaxWidth()
              .padding(horizontal = 40.dp)) {
            Text(text="Log in",fontSize=40.sp)
            OutlinedTextField(value = username, onValueChange ={username=it},
            modifier= Modifier
                .fillMaxWidth()
                .focusRequester(focusUsername),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {focusPssword.requestFocus()}),
                singleLine =true,
                label = {Text(text="Username")}
            )
            Spacer(modifier = Modifier.height(20.dp))
OutlinedTextField(
    modifier= Modifier
        .fillMaxWidth()
        .focusRequester(focusPssword),
    value = password, onValueChange ={password=it},
    label = {Text(text="Password")},
singleLine = true,
keyboardOptions=KeyboardOptions(keyboardType= KeyboardType.Password, imeAction = ImeAction.Done),
    keyboardActions = KeyboardActions(onDone ={keyboardController?.hide()}),
    visualTransformation = if(isPasswordVisiable)VisualTransformation.None else PasswordVisualTransformation(),
    trailingIcon={
IconButton(onClick = { isPasswordVisiable=!isPasswordVisiable }) {
Icon(
    imageVector = if (isPasswordVisiable) Icons.Default.LockOpen else Icons.Default.Lock,
    contentDescription = "Password Toggle"
)
}
    }
    )
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), Arrangement.SpaceBetween
            ) {
Row(verticalAlignment = Alignment.CenterVertically){
    Checkbox(checked = checkedState, onCheckedChange = {})
    Text(text="Remember me",fontSize=12.sp)
}

                TextButton(onClick = {  }) {
                    Text(text="Forget Password",fontSize=12.sp)
                }
            }
Spacer(modifier = Modifier.height(25.dp))
val context= LocalContext.current
Button(onClick = { if(username.isEmpty()||password .contains('_')||
    password.contains('@')||password .contains('$')||password .contains('#')
    ||password .contains('%')||password.isEmpty()||password.length<8) {
    Toast.makeText( context,"InValid Username or Password!",Toast.LENGTH_LONG).show()
}else {
    Toast.makeText(context, "welcome $username", Toast.LENGTH_LONG).show()
}
},
    modifier=Modifier.fillMaxWidth(),
shape = RoundedCornerShape(16.dp)

) {
Text(text="Log in")
}
Spacer(modifier = Modifier.height(16.dp))
            Row(modifier=Modifier.fillMaxWidth(),Arrangement.Center)
            {
Text(text = "Or log in with",fontSize=14.sp)
            }
            Row(modifier=Modifier.fillMaxWidth(),Arrangement.SpaceAround){
              Button( colors = ButtonDefaults.buttonColors(containerColor = Color.White),onClick = {  },
                  shape= RoundedCornerShape(50),
              modifier= Modifier
                  .height(45.dp)
                  .width(45.dp)
              ) {
Image(painter = painterResource(id = R.drawable.facebook), contentDescription ="Facebook Logo",
modifier= Modifier
    .weight(1f)
    .size(40.dp)
    )
              }
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White) ,onClick = { },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .height(45.dp)
                        .width(45.dp),

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "",
                        modifier = Modifier.weight(1f).size(40.dp)
                    )

                }
                Button( colors = ButtonDefaults.buttonColors(containerColor = Color.White),onClick = {  },
                    shape= RoundedCornerShape(50),
                    modifier= Modifier
                        .height(45.dp)
                        .width(45.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.twitter), contentDescription ="Facebook Logo",
                        modifier= Modifier
                            .weight(1f)
                            .size(40.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(modifier=Modifier.fillMaxWidth(),Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text="Don't have account?", fontSize = 14.sp)

TextButton(onClick = { /*TODO*/ }) {
  Text(text = "Register now")
}

            }
            Spacer(modifier = Modifier.height(25.dp))
                }

        }
    }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyLoginInScreenTheme {
       LogininScreen()
    }
}