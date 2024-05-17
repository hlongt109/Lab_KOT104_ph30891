package com.ph30891.bai5_ph30891.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ph30891.bai5_ph30891.R

@Composable
fun CartScreen() {
    var selectedPaymentMethod by rememberSaveable { mutableStateOf("") }
    val paymentMethods = listOf("Paypal", "Visa", "Momo", "ZaloPay", "COD")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(15.dp)
    ) {
        Text(
            text = "Payment",
            fontSize = MaterialTheme.typography.h4.fontSize,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.CenterHorizontally)
        )
        AddressSection()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Select a payment method :",
            style = MaterialTheme.typography.h6,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        PaymentMethodList(paymentMethods = paymentMethods, selectedMethod = selectedPaymentMethod ) { method ->
            selectedPaymentMethod = method
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = "Continue",color = Color.White,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}

@Composable
fun AddressSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Delivery address :",
            style = MaterialTheme.typography.body1,
            color = Color.White,
            modifier = Modifier.padding(bottom = 7.dp)

        )
        Text(text = "Name : Tran Hoang Long", style = MaterialTheme.typography.caption,color = Color.White,)
        Text(text = "Phone number : 0869078833", style = MaterialTheme.typography.caption,color = Color.White,)
        Text(
            text = "Address : Ngo 103, duong Xuan Phuong, Nam Tu Liem, Ha Noi ",
            color = Color.White,
            style = MaterialTheme.typography.caption
        )
    }
}

@Composable
fun PaymentMethodList(
    paymentMethods: List<String>,
    selectedMethod: String,
    onSelectionChange: (String) -> Unit
) {
    LazyColumn {
        items(paymentMethods.size) { index: Int ->
            val method = paymentMethods[index]
            PaymentMethodItem(
                method = method,
                isSeleced = method == selectedMethod,
                onSelected = { onSelectionChange(method) },
                backgroundColor = when (index % 5) {
                    0 -> Color(0xFFFFA500)
                    1 -> Color.White
                    2 -> Color(0xFFFFC0CB)
                    3 -> Color(0xFFADD8E6)
                    else -> Color(0xFF90EE90)
                },
                Index = index
            )

            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}

@Composable
fun PaymentMethodItem(method: String, isSeleced: Boolean, onSelected: () -> Unit, backgroundColor: Color, Index: Int) {
    val imageResources = listOf(
        R.drawable.paypal,
        R.drawable.visa,
        R.drawable.momo,
        R.drawable.zlpay,
        R.drawable.money
    )
    val imageResource = imageResources[Index % imageResources.size]


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = isSeleced,
                onClick = onSelected
            )
            .padding(7.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .border(
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier.size(30.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = method,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.weight(1f)
        )
        RadioButton(selected = isSeleced, onClick = onSelected)
    }
}

@Composable
@Preview
fun CartScreenPreview() {
    CartScreen()
}