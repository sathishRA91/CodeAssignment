package com.sathish.codeassignment.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sathish.codeassignment.domain.model.AssociatedDrugData
import com.sathish.codeassignment.presentation.ui.UiState
import com.sathish.codeassignment.presentation.ui.route.Screens
import java.time.LocalTime

/**
 * Created by sathish on 11,July,2024
 */

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController,userName:String,homeViewModel: HomeViewModel = hiltViewModel())
{

    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize()) {
        Column(horizontalAlignment = Alignment.End,
            modifier = Modifier.wrapContentSize()) {
            TopAppBar(title = { /*TODO*/ })
            Text(modifier = Modifier
                .wrapContentWidth()
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),text = updateGreeting(userName),
                fontSize = 18.sp, color = Color.Black)

            LoadMedicineList(navController,uiState)
        }

    }
}

@Composable
private fun MedicineItem(navController: NavController,medicineList:List<AssociatedDrugData>?)
{
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        medicineList?.let {
            items(it){
                Card(modifier = Modifier.padding(8.dp).fillMaxWidth().clickable {
                    navController.navigate(Screens.Detail.withArgs(it.name,it.dose.ifEmpty { "No Data" },it.strength))
                },
                    border = BorderStroke(1.dp, color = Color.LightGray),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Text(modifier = Modifier.padding(7.dp), text ="Name: ${it.name}")
                    Text(modifier = Modifier.padding(7.dp), text ="Strength: ${it.strength}")
                    Text(modifier = Modifier.padding(7.dp), text ="Dose: ${it.dose.ifEmpty { "No Data" }}")
                }
            }
        }
    }

}

@Composable
private fun LoadMedicineList(navController: NavController,uiState:UiState<List<AssociatedDrugData>>)
{
    when(uiState)
    {
        is UiState.Loading -> CircularProgressIndicator()
        is UiState.Success -> {
            MedicineItem(navController,uiState.data)
        }
        else -> {}
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun updateGreeting(userName:String):String {
    val currentTime = LocalTime.now()
   return when (currentTime.hour) {
        in 5..11 -> "Good Morning"
        in 12..17 -> "Good Afternoon"
        in 18..21 -> "Good Evening"
        else -> "Good Night"
    } +" $userName"
}

