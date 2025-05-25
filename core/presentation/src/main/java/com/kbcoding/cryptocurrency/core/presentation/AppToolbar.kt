package com.kbcoding.cryptocurrency.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kbcoding.cryptocurrency.core.presentation.ui.theme.TextWhite

sealed class NavigateUpAction {
    data object Hidden : NavigateUpAction()
    data class Visible(val onClick: () -> Unit) : NavigateUpAction()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    titleRes: String,
    navigateUpAction: NavigateUpAction,
) {

    CenterAlignedTopAppBar(
        title = {
            Text(text = titleRes, color = TextWhite)
        },
        navigationIcon = {
            if (navigateUpAction is NavigateUpAction.Visible) {
                IconButton(
                    onClick = navigateUpAction.onClick
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
//            .drawBehind {
//                drawRect(
//                    brush = Brush.verticalGradient(
//                        colors = listOf(
//                            Color.Black.copy(alpha = 0.07f),
//                            Color.Transparent
//                        ),
//                        startY = size.height,
//                        endY = size.height + 20.dp.toPx()
//                    ),
//                    topLeft = Offset(0f, size.height),
//                    size = Size(size.width, 20.dp.toPx())
//                )
//            }
            .shadow(
                elevation = 20.dp,
                spotColor = Color.Black.copy(alpha = 1f),
                ambientColor = Color.Black.copy(alpha = 1f)
            )
            .drawBehind {
                drawRect(
                    color = Color.Black,
                    size = size
                )
            }
    )
}