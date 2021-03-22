package com.compose.simple.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @Author petterp
 * @Date 2021/3/11-9:25 下午
 * @Email ShiyihuiCloud@163.com
 * @Function ColumnSimple
 */

@Composable
fun ColumnSimple(
    text: String,
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier
            .background(color = Color.Yellow)
            .padding(5.dp),
        verticalArrangement, horizontalAlignment
    ) {
        Text(text = text, color = Color.Black)
    }
}

@Preview(widthDp = 200, name = "默认的排列方式")
@Composable
fun PreviewColumnDefault() {
    ColumnSimple("默认排列方式")
}

@Preview(widthDp = 200, heightDp = 100, name = "自定义垂直的排列方式")
@Composable
fun PreviewColumnVertical() {
    val modifier = Modifier
        .fillMaxHeight()
        .width(60.dp)
    // bias位置范围 (-1,1)
    //其中 [0] 表示居中，[1] 表示在底部 ,[-1] 表示在顶部 ,[-1,1]范围之内则表示自定义的区间
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        ColumnSimple(
            text = "Top",
            modifier = modifier,
            verticalArrangement = Arrangement.aligned(BiasAlignment.Vertical(-1f)),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        Spacer(modifier = Modifier.width(10.dp))
        ColumnSimple(
            text = "Center",
            modifier,
            verticalArrangement = Arrangement.aligned(BiasAlignment.Vertical(0F)),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        Spacer(modifier = Modifier.width(10.dp))
        ColumnSimple(
            text = "Bottom",
            modifier,
            verticalArrangement = Arrangement.aligned(BiasAlignment.Vertical(1f)),
            horizontalAlignment = Alignment.CenterHorizontally
        )
    }
}

@Preview(widthDp = 200, heightDp = 200, name = "自定义水平的排列方式")
@Composable
fun PreviewColumnHorizontal() {
    val modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
    // bias位置范围 (-1,1)
    //其中 [0] 表示居中，[-1] 表示在左侧 ,[-1] 表示在右侧 ,[-1,1]范围之内则表示自定义的区间
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        ColumnSimple(
            text = "Start",
            modifier = modifier,
            horizontalAlignment = BiasAlignment.Horizontal(-1f),
            verticalArrangement = Arrangement.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        ColumnSimple(
            text = "Top",
            modifier,
            horizontalAlignment = BiasAlignment.Horizontal(0f),
            verticalArrangement = Arrangement.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        ColumnSimple(
            text = "End",
            modifier,
            horizontalAlignment = BiasAlignment.Horizontal(1f),
            verticalArrangement = Arrangement.Center
        )
    }
}

@Preview(widthDp = 200, heightDp = 100, name = "BiasAbsoluteAlignment")
@Composable
fun PreviewBiasAlignment() {
    val modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
    ColumnSimple(
        text = "!23",
        modifier = modifier,
    )
}