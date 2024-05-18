package com.example.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BizCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = {
                            Text(text = "BizCard")
                        })
                    }
                ) {
                    innerPadding ->
                    CreateBizCard(modifier = Modifier.padding((innerPadding)))
                }
            }
        }
    }
}


@Composable
fun CreateBizCard(modifier: Modifier = Modifier){
    Surface(modifier= Modifier
        .fillMaxSize()
        .fillMaxHeight()){
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White,),

            shape = RoundedCornerShape(corner = CornerSize(30.dp)),
            elevation = CardDefaults.cardElevation(4.dp),
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 120.dp)) {
                CreateProfilePicture()
                Divider(modifier=Modifier.fillMaxWidth(), thickness = 3.dp,color=Color.LightGray)
                CreateProfileInfoSection()

            }

        }
    }
}
@Composable
private fun CreateProfilePicture(){
    Surface(modifier= Modifier
        .size(150.dp)
        .padding(10.dp),
        shape= CircleShape,
        border= BorderStroke(0.5.dp, Color.LightGray),
        tonalElevation = 4.dp,
        color = MaterialTheme.colorScheme.surface.copy(alpha=0.5f)

    ) {
        Image(painter = painterResource(id = R.drawable.profile_picture), contentDescription = "Profile Picture", contentScale = ContentScale.Crop)

    }
}
@Composable
private fun CreateProfileInfoSection(){
   Column(modifier = Modifier.padding(5.dp)) {
       Text(text="John Doe",
           style=MaterialTheme.typography.headlineLarge,
           color = MaterialTheme.colorScheme.primary
       )
       Text(text="Software Developer",
           modifier = Modifier.padding(3.dp),
       )
       Text(text="@Apple",
           modifier = Modifier.padding(3.dp),
           style = MaterialTheme.typography.labelMedium
       )
   }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardTheme {
        CreateBizCard()
    }
}