package com.example.ComposeUiProject.QuizUi.Leader.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ComposeUiProject.QuizUi.Leader.Model.UserModel
import androidx.core.graphics.toColorInt
import com.example.ComposeUiProject.R


@Composable
fun TopUserBox(
    user: UserModel,
    rank: Int,
    color: String,
    sizeDp: Int,
    crow: Boolean = false,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(sizeDp.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ConstraintLayout(
            modifier = Modifier
                .height(240.dp)
                .width(sizeDp.dp)
        ) {
            val (imgRef, badgeRef, crownRef) = createRefs()

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(getDrawableId(user.pic))
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(sizeDp.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        Color(color.toColorInt()),
                        CircleShape
                    )
                    .constrainAs(imgRef) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            if (crow) {
                Image(
                    painter = painterResource(R.drawable.crown),
                    contentDescription = null,
                    modifier = Modifier
                        .constrainAs(crownRef) {
                            top.linkTo(imgRef.top)
                            bottom.linkTo(imgRef.top)
                            start.linkTo(imgRef.start)
                            end.linkTo(imgRef.end)
                        }
                )
            }

            Box(
                Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color(color.toColorInt()))
                    .constrainAs(badgeRef) {
                        top.linkTo(imgRef.bottom)
                        bottom.linkTo(imgRef.bottom)
                        start.linkTo(imgRef.start)
                        end.linkTo(imgRef.end)
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = rank.toString(),
                    color = Color.White,
                    fontSize = if (rank == 1) 20.sp else 16.sp,
                    textAlign = TextAlign.Center
                )
            }

            Text(
                text = user.name,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
        Row(
            modifier = Modifier
                .height(30.dp)
                .wrapContentWidth()
                .background(
                    brush = SolidColor(Color(color.toColorInt())),
                    shape = RoundedCornerShape(50)
                )
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.garnet),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = user.score.toString(),
                color = Color.White,
            )
        }
    }
}


@Composable
fun TopThreeSection(
    users: List<UserModel>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        TopUserBox(
            user = users[2], rank = 3, color = "#ae844f", sizeDp = 100,
        )
        TopUserBox(
            user = users[0], rank = 1, color = "#febb3a", sizeDp = 130, crow = true
        )
        TopUserBox(
            user = users[1], rank = 2, color = "#bfbfc0", sizeDp = 100,
        )
    }
}

@Preview
@Composable
fun TopThreeSectionPreview() {
    val users = listOf(
        UserModel(
            id = 1, name = "John Doe", pic = "person1", score = 300
        ),
        UserModel(
            id = 2, name = "Jane Smith", pic = "person2", score = 200
        ),
        UserModel(
            id = 3, name = "Peter Jones", pic = "person3", score = 100
        )
    )
    TopThreeSection(
        users = users
    )
}

@Composable
fun getDrawableId(name: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(name, "drawable", context.packageName)
}

@Preview
@Composable
fun TopUserBoxPreview() {
    val user =
        UserModel(id = 1, name = "John Doe", pic = "person1", score = 100)
    TopUserBox(
        user = user,
        rank = 1,
        color = "#ae844f",
        sizeDp = 100,
        crow = true
    )
}