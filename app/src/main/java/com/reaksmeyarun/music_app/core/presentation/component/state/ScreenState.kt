package com.reaksmeyarun.music_app.core.presentation.component.state

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.reaksmeyarun.music_app.core.presentation.component.button.ButtonModifier
import com.reaksmeyarun.music_app.core.presentation.component.button.ButtonComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.Header5TextModifier
import com.reaksmeyarun.music_app.core.presentation.component.text.TextModifier

@Composable
fun ScreenState(
    title: String,
    description: String,
    @DrawableRes resource: Int,
    tryAgainState: MutableState<Boolean>,
    tryAgainClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (appBarRefs, imageRefs, headerRefs, descriptionRefs, tryAgainRefs) = createRefs()
            Image(painter = painterResource(id = resource),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(imageRefs) {
                        top.linkTo(appBarRefs.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        verticalBias = 0.3f
                    }
                    .fillMaxWidth(0.7f)
                    .aspectRatio(1f))
            TextComponent(
                text = title,
                textModifier = Header5TextModifier()
                    .textAlign(textAlign = TextAlign.Center),
                modifier = Modifier
                    .padding(top = 24.dp)
                    .constrainAs(headerRefs) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(imageRefs.bottom)
                    }
            )
            TextComponent(
                text = description,
                textModifier = TextModifier()
                    .textAlign(textAlign = TextAlign.Center),
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 24.dp)
                    .constrainAs(descriptionRefs) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(headerRefs.bottom)
                    }
            )
            if (tryAgainState.value)
                ButtonComponent(
                    value = "Try Again",
                    buttonModifier = ButtonModifier(),
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 24.dp)
                        .constrainAs(tryAgainRefs) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(descriptionRefs.bottom)
                        }
                    ,
                    onClick = tryAgainClick
                )
        }
    }
}