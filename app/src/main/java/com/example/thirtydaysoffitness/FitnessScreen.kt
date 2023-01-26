package com.example.thirtydaysoffitness

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysoffitness.model.Fitness
import com.example.thirtydaysoffitness.model.FitnessRepository
import com.example.thirtydaysoffitness.ui.theme.ThirtyDaysOfFitnessTheme

@Composable
fun FitnessApp() {
    Scaffold(
        topBar = { FitnessTopAppBar()},
        content = {
            FitnessCardList(
                modifier = Modifier.padding(paddingValues = it),
                fitnessList = FitnessRepository.fit
            )
        }
    )
}

@Composable
fun FitnessCardList(
    fitnessList: List<Fitness>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp),
        modifier = modifier.background(MaterialTheme.colors.background)
    ) {
        items(fitnessList) {
            FitnessCard(fitness = it)
        }

    }
}

@Composable
fun FitnessCard(
    fitness: Fitness,
    modifier: Modifier = Modifier
) {
    var isClicked by remember{ mutableStateOf(false) }
    val sz = if (isClicked) 200.dp else 100.dp

   Card(
       elevation = 4.dp,
       modifier = modifier
           .padding(10.dp)
           .fillMaxWidth()
           .size(sz)
           .clickable {
               isClicked = !isClicked
           }
   ) {
      Column {
          Row {
              FitnessExceriseImage(fitness.descriptionImage)
              FitnessDescription(fitness.day, fitness.exercise, fitness.reps)
          }
          if (isClicked) {
              ExtraFitnessInformation(info = fitness.description)
          }
      }

   }
}

@Composable
fun FitnessDescription(
    @StringRes day: Int,
    @StringRes excerise: Int,
    @StringRes reps: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row {
            Text(
                text = stringResource(day),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                text = stringResource(excerise),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(start = 2.dp)
            )
        }
        Text(
            text = stringResource(reps),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onSurface
        )
    }
}


@Composable
fun FitnessExceriseImage(
    @DrawableRes  exceriseImg: Int,
    modifier: Modifier = Modifier
) {
        Image(
            painter = painterResource(exceriseImg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(100.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(16.dp))
        )
}

@Composable
fun ExtraFitnessInformation(@StringRes info: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(info),
        style = MaterialTheme.typography.body1,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun FitnessPreview() {
    ThirtyDaysOfFitnessTheme(darkTheme = true) {
        FitnessApp()
    }
}
