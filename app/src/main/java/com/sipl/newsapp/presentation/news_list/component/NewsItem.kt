package com.sipl.newsapp.presentation.news_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.sipl.newsapp.data.remote.dto.Article


@Composable
fun NewsItem(
    coin: Article,
    onItemClick: (Article) -> Unit
) {
    Card(elevation = 15.dp, backgroundColor = Color.White, modifier = Modifier.absolutePadding(10.dp,10.dp,10.dp,10.dp)) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(coin) }
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = "${coin.title}",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight(100)

                )
                Text(
                    text = coin.description,
                    color = Color(0xff898989),
                    fontStyle = FontStyle.Normal,


                    style = MaterialTheme.typography.body1,

                    )

                    Image(
                        painter = rememberAsyncImagePainter(coin.urlToImage),
                        contentDescription = null,
                        modifier = Modifier.size(350.dp).fillMaxSize(1f),

                    )


            }
        }
    }
}