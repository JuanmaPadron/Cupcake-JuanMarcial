package com.example.codelabnavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codelabnavigation.data.DataSource

enum class CupCakeScreen(){
    Start, Flavor, Pickup, Summary, PantallaEjemplo
}
@Composable
fun CupCakeApp(navController: NavHostController = rememberNavController()) {
    Scaffold() { innerPadding ->
        //  val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = CupCakeScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = CupCakeScreen.Start.name) {
                StartOrderScreen(
                    quantityOptions = DataSource.quantityOptions,
                    onNextButtonClicked = { cupcakeQuantity -> viewModel.setQuantity(cupcakeQuantity) },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = CupCakeScreen.PantallaEjemplo.name){
                EjemploPantalla()
            }
        }
    }
}