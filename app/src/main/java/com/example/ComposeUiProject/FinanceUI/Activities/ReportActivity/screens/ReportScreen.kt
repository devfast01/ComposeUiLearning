package com.example.ComposeUiProject.Activities.ReportActivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.ComposeUiProject.R
import com.example.ComposeUiProject.Activities.DashboardAcivity.components.BottomNavigationBar
import com.example.ComposeUiProject.Activities.ReportActivity.components.BudgetItem
import com.example.ComposeUiProject.Activities.ReportActivity.components.CenterStatsCard
import com.example.ComposeUiProject.Activities.ReportActivity.components.GradientHeader
import com.example.ComposeUiProject.Activities.ReportActivity.components.SummaryColumns
import com.example.ComposeUiProject.Domain.BudgetDomain


@Preview
@Composable
fun ReportScreenPreview() {
    val budgets = listOf(
        BudgetDomain("Home Load", 1200.3, 80.0),
        BudgetDomain("Subscription", 500.3, 50.0),
        BudgetDomain("Car Loan", 1200.3, 30.0)
    )

    ReportScreen(budgets) {}
}


@Composable
fun ReportScreen(
    budgets: List<BudgetDomain>,
    onBack: () -> Unit,
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (scrollRef, bottomBarRef) = createRefs()

        ReportContent(
            budgets,
            modifier = Modifier
                .constrainAs(scrollRef) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(
                        parent.end
                    )
                    bottom.linkTo(bottomBarRef.top)
                }, onBack
        )

        BottomNavigationBar(
            modifier = Modifier
                .height(80.dp)
                .constrainAs(bottomBarRef) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onItemSelected = { itemId ->
                if (itemId == R.id.wallet) {

                }
            }
        )


    }

}

@Composable
fun ReportContent(
    budgets: List<BudgetDomain>,
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    LazyColumn(
        modifier =
            modifier.background(Color.White)
    ) {
        item {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                val (header, card) = createRefs()
                GradientHeader(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .constrainAs(header) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .padding(top = 20.dp), onBack
                )

                CenterStatsCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp)
                        .constrainAs(card) {
                            top.linkTo(header.bottom)
                            bottom.linkTo(header.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
            }
        }
        item {
            SummaryColumns(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
                    .padding(horizontal = 24.dp)
                    .background(
                        color = colorResource(R.color.lightBlue),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(8.dp)
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "My budget", fontWeight = FontWeight.Bold, fontSize = 19.sp,
                    color = colorResource(R.color.darkBlue)
                )

                Text("Edit", color = colorResource(R.color.darkBlue))
            }
        }

        itemsIndexed(budgets) { index, item ->
            BudgetItem(budget = item, index = index)
        }

    }
}