package com.example.lemonade

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeDemoApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeDemoApp(modifier: Modifier=Modifier){

    var counter by remember {
        mutableStateOf(0)
    }
    val arrayOfStringRes = arrayListOf<String>(
        stringResource(id =R.string.lemonade_tree),
        stringResource(id = R.string.lemonade),
        stringResource(id = R.string.glass_of_lemonade),
        stringResource(id = R.string.empty_glass)
    )

    val arrayOfTextStrings = arrayListOf<String>(
        stringResource(id = R.string.tap_tree),
        stringResource(id = R.string.retape),
        stringResource(id = R.string.drink),
        stringResource(id = R.string.restart)
    )

    val currentImag =when(counter){
        0->R.drawable.lemon_tree
        1->R.drawable.lemon_squeeze
        2->R.drawable.lemon_drink
        3->R.drawable.lemon_restart
        else-> R.drawable.lemon_restart
    }
    Column (
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ){
        Button(onClick = {

                             counter += 1

                            if(counter >=4){
                                counter =0
                            }
                         },
        shape = RoundedCornerShape(5.dp)
        ) {
            Image(
                painter = painterResource(id = currentImag),
                contentDescription = arrayOfStringRes.get(counter)
            )

        }
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = arrayOfTextStrings.get(counter))
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeDemoShow(){
    LemonadeTheme {
        LemonadeDemoApp()
        
    }
}
