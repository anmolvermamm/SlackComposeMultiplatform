package dev.baseio.slackclone.uionboarding.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import dev.baseio.slackclone.commonui.material.SlackSurfaceAppBar
import dev.baseio.slackclone.commonui.theme.*
import dev.baseio.slackclone.navigation.ComposeNavigator
import dev.baseio.slackclone.navigation.SlackScreens

@Composable
fun SkipTypingUI(composeNavigator: ComposeNavigator) {
  val scaffoldState = rememberScaffoldState()
  Scaffold(
    backgroundColor = SlackCloneColor,
    contentColor = SlackCloneColorProvider.colors.textSecondary,
    modifier = Modifier, scaffoldState = scaffoldState,
    topBar = {
      SlackSurfaceAppBar(
        title = {

        },
        navigationIcon = {
          IconButton(onClick = {
            composeNavigator.navigateUp()
          }) {
            Icon(
              imageVector = Icons.Filled.Clear,
              contentDescription = "Clear",
              modifier = Modifier.padding(start = 8.dp), tint = Color.White
            )
          }
        },
        backgroundColor = SlackCloneColor,
        elevation = 0.dp
      )
    },
    snackbarHost = {
      scaffoldState.snackbarHostState
    }
  ) { innerPadding ->
    Box(modifier = Modifier.padding(innerPadding)) {
      SlackCloneSurface(
        color = SlackCloneColor,
        modifier = Modifier
          .padding(28.dp)
      ) {
        Column(
          verticalArrangement = Arrangement.SpaceAround,
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
        ) {
          val painter = PainterRes.gettingStarted()
          Image(
            modifier = Modifier.weight(1f, fill = false)
              .aspectRatio(painter.intrinsicSize.height / painter.intrinsicSize.width)
              .fillMaxWidth(),
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit
          )
          TitleSubtitleText()
          Spacer(Modifier.padding(8.dp))
          Column {
            EmailMeMagicLink(composeNavigator)
            Box(modifier = Modifier.height(12.dp))
            IWillSignInManually(composeNavigator)
          }

        }

      }
    }

  }


}

@Composable
fun EmailMeMagicLink(composeNavigator: ComposeNavigator) {
  OutlinedButton(
    onClick = {
      composeNavigator.navigateScreen(SlackScreens.EmailAddressInputUI)
    },
    border = BorderStroke(1.dp, color = Color.White),
    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
    modifier = Modifier
      .fillMaxWidth()
      .height(40.dp),
  ) {
    Text(
      text = "Email me a magic link",
      style = SlackCloneTypography.subtitle2.copy(color = Color.White)
    )
  }
}

@Composable
private fun IWillSignInManually(composeNavigator: ComposeNavigator) {
  Button(
    onClick = {
      composeNavigator.navigateScreen(SlackScreens.WorkspaceInputUI)
    },
    Modifier
      .fillMaxWidth()
      .height(40.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
  ) {
    Text(
      text = "I'll sign in manually",
      style = SlackCloneTypography.subtitle2.copy(color = SlackCloneColor)
    )
  }
}

@Composable
private fun TitleSubtitleText(modifier: Modifier = Modifier) {
  Text(
    text = buildAnnotatedString {
      withStyle(
        style = SpanStyle(
          fontWeight = FontWeight.Bold,
          fontSize = SlackCloneTypography.h6.fontSize, color = Color.White
        )
      ) {
        append("Want to skip the typing ?\n\n")
      }
      withStyle(
        style = SpanStyle(
          fontWeight = FontWeight.Normal,
          fontSize = SlackCloneTypography.subtitle2.fontSize, color = Color.White
        )
      ) {
        append("We can email you a magic sign-in link that adds all your workspaces at once")
      }
    },
    textAlign = TextAlign.Center,
    modifier = modifier.fillMaxWidth(),
    style = SlackCloneTypography.h4
  )
}
