package com.thoen.zaladaandroid.views.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.thoen.zaladaandroid.R
import com.thoen.zaladaandroid.component.ButtonBack
import com.thoen.zaladaandroid.router.Search
import com.thoen.zaladaandroid.views.favorite.screen.ShapeIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductAllScreen(
    navController: NavController
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "All Product",
                        color = Color.Black,
                        fontWeight = FontWeight.W600,
                        fontSize = 24.sp
                    )
                },
                navigationIcon = {
                    Box (
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)

                    ){
                        ButtonBack(
                            onClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                },
                actions = {
                    ShapeIcons(
                        onClick = {
                            navController.navigate(Search.route)
                        },
                        icon = R.drawable.search_light
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                }
            )

        },
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .imePadding()
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
                ListProduct()

            }
        }

    }

}
@Composable
fun ListProduct() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(10) {
            ListProducts(
                end = false,
            )
        }
    }
}