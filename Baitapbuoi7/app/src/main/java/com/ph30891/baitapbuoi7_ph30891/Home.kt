
package com.ph30891.baitapbuoi7_ph30891

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Chair
import androidx.compose.material.icons.filled.ChairAlt
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.TableBar
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.rememberImagePainter
import com.ph30891.baitapbuoi7_ph30891.ui.theme.Gelasio
import com.ph30891.baitapbuoi7_ph30891.ui.theme.Nunito_Sans


data class Category(val id: String,val name: String, val icon: @Composable (Color) -> Unit)
data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val imageUrl: String,
    val categoryId: String,
    val productClassify: List<Classify>,
    val description:String
)
data class Classify(val id: String, val color: String, val photo:String)

val fake_products = listOf(
   Product(1, "Chair 1", "$50", "https://via.placeholder.com/150", "C2",
      productClassify = listOf(
         Classify(id="ls1", color = "#ffffff", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#8B4513", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#F5F5DC", photo = "https://via.placeholder.com/150"),
      ),
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
   ),
   Product(2, "Chair 2", "$50", "https://via.placeholder.com/150", "C2",
      productClassify = listOf(
         Classify(id="ls1", color = "#ffffff", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#8B4513", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#F5F5DC", photo = "https://via.placeholder.com/150"),
         ),
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
      ),
   Product(3, "Chair 3", "$50", "https://via.placeholder.com/150", "C2",
      productClassify = listOf(
         Classify(id="ls1", color = "#ffffff", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#8B4513", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#F5F5DC", photo = "https://via.placeholder.com/150"),
         ),
       "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
   ),
   Product(4, "Chair 4", "$50", "https://via.placeholder.com/150", "C2",
      productClassify = listOf(
         Classify(id="ls1", color = "#ffffff", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#8B4513", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#F5F5DC", photo = "https://via.placeholder.com/150"),
      ),
       "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
   ),
   Product(5, "Chair 5", "$50", "https://via.placeholder.com/150", "C2",
      productClassify = listOf(
         Classify(id="ls1", color = "#ffffff", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#8B4513", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#F5F5DC", photo = "https://via.placeholder.com/150"),
      ),
       "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
   ),
   Product(2, "Table 1", "$150", "https://via.placeholder.com/150", "C3",
      productClassify = listOf(
         Classify(id="ls1", color = "#ffffff", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#8B4513", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#F5F5DC", photo = "https://via.placeholder.com/150"),
      ),
       "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
   ),
   Product(3, "Armchair 1", "$70", "https://via.placeholder.com/150", "C4",
      productClassify = listOf(
         Classify(id="ls1", color = "#ffffff", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#8B4513", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#F5F5DC", photo = "https://via.placeholder.com/150"),
      ),
       "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
   ),
   Product(4, "Bed 1", "$200", "https://via.placeholder.com/150", "C5",
      productClassify = listOf(
         Classify(id="ls1", color = "#ffffff", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#8B4513", photo = "https://via.placeholder.com/150"),
         Classify(id="ls1", color = "#F5F5DC", photo = "https://via.placeholder.com/150"),
      ),
       "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
   ),
)

@Preview(showBackground = true)
@Composable
fun Home(){
   val categories = listOf(
      Category("C1","Popular", { color -> Icon(Icons.Default.Star, contentDescription = null, modifier = Modifier.size(29.dp), tint = color) }),
      Category("C2","Chair", { color -> Icon(Icons.Default.ChairAlt, contentDescription = null, modifier = Modifier.size(29.dp), tint = color) }),
      Category("C3","Table", { color -> Icon(Icons.Default.TableBar, contentDescription = null, modifier = Modifier.size(29.dp), tint = color) }),
      Category("C4","Armchair", { color -> Icon(Icons.Default.Chair, contentDescription = null, modifier = Modifier.size(29.dp), tint = color) }),
      Category("C5","Bed", { color -> Icon(Icons.Default.Bed, contentDescription = null, modifier = Modifier.size(29.dp), tint = color) }),
      Category("C6","Cabinet", { color -> Icon(Icons.Default.Kitchen, contentDescription = null, modifier = Modifier.size(29.dp), tint = color) })
   )
   val selectedCategoryIndex = remember { mutableStateOf(0) }
   var selectedCategoryId = categories[selectedCategoryIndex.value].id
   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(Color("#FFFFFF".toColorInt()))
   ){
     Column(
        modifier = Modifier
           .padding(8.dp)
     ) {
        Row(
           verticalAlignment = Alignment.CenterVertically
        ) {
           IconButton(
              onClick = { /*TODO*/ }
           ) {
              Icon(
                 Icons.Default.Search, contentDescription = null,
                 modifier = Modifier.size(30.dp),
                 Color("#909090".toColorInt())
              )
           }
           Spacer(modifier = Modifier.weight(1f))
           Column(
              horizontalAlignment = Alignment.CenterHorizontally
           ) {
              Text(
                 text = "Make home",
                 fontSize = 20.sp,
                 fontFamily = Gelasio,
                 fontWeight = FontWeight.Normal,
                 color = Color("#909090".toColorInt())
              )
              Text(
                 text = "BEAUTIFUL",
                 fontSize = 20.sp,
                 color = Color("#242424".toColorInt()),
                 fontFamily = Gelasio,
                 fontWeight = FontWeight.Bold,
              )
           }
           Spacer(modifier = Modifier.weight(1f))
           IconButton(
              onClick = { /*TODO*/ }
           ) {
              Icon(Icons.Outlined.ShoppingCart, contentDescription = null,
                 modifier = Modifier.size(30.dp),
                 tint = Color("#909090".toColorInt())
              )
           }
        }
        // category
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
           horizontalArrangement = Arrangement.spacedBy(20.dp),
           modifier = Modifier.padding(horizontal = 10.dp)
        ) {
           items(categories.size){index: Int ->
              CategoryItem(
                 category =  categories[index],
                 isSelected = selectedCategoryIndex.value == index,
                 onClick = {selectedCategoryIndex.value = index}
              )
           }
        }

        // danh sách sản phẩm theo category (2 cột)
       ProductList(product = fake_products, selectedCategoryId = selectedCategoryId)
     }
   }
}


@Composable
fun CategoryItem(category: Category, isSelected: Boolean, onClick: () -> Unit){
   val selectedColor = if(isSelected) Color("#303030".toColorInt()) else Color("#F5F5F5".toColorInt())
   val contentColor = if(isSelected) Color("#ffffff".toColorInt()) else Color("#909090".toColorInt())
   val textColor = if (isSelected)  Color("#242424".toColorInt()) else Color("#999999".toColorInt())
   Column(
      modifier = Modifier
         .clickable(onClick = onClick)
         .padding(5.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
   ) {
      Box(
         contentAlignment = Alignment.Center,
         modifier = Modifier
            .size(52.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(selectedColor),
      ){
         category.icon(contentColor)
      }
      Spacer(modifier = Modifier.height(4.dp))
      Text(
         text = category.name,
         color = textColor,
         fontSize = 15.sp,
         fontFamily = Nunito_Sans,
         fontWeight = FontWeight.SemiBold
      )
   }
}
@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier, onClick: () -> Unit){
   Column(
      modifier = modifier
         .padding(10.dp)
         .clickable(onClick = onClick),
   ) {
      Box(
         modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color("#F5F5F5".toColorInt())),
         contentAlignment = Alignment.BottomEnd
      ){
         Image(
            painter = rememberImagePainter(data = product.imageUrl),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
         )
         IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
               .padding(10.dp)
               .background(
                  Color("#606060".toColorInt()).copy(alpha = 0.3f),
                  shape = RoundedCornerShape(10.dp)
               )
               .width(35.dp)
               .height(35.dp)
         ) {
            Icon(
               painter = painterResource(id = R.drawable.ic_shopping_bag),
               contentDescription = null,
               modifier = Modifier
                  .size(20.dp),
               tint = Color.White
            )
         }
      }
      Spacer(modifier = Modifier.height(10.dp))
      Text(text = product.name, fontSize = 16.sp, fontFamily = Nunito_Sans, fontWeight = FontWeight.Normal, color = Color("#606060".toColorInt()))
      Text(text = product.price, fontSize = 16.sp, fontFamily = Nunito_Sans, fontWeight = FontWeight.Bold, color = Color("#303030".toColorInt()))
   }
}

@Composable
fun ProductList(product: List<Product>, selectedCategoryId: String){
   val filter = product.filter { it.categoryId == selectedCategoryId }
   LazyColumn {
      items(filter.chunked(2)){rowItem ->
         Row(
            modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
         ) {
            for(item in rowItem){
               ProductItem(
                  product = item,
                  modifier = Modifier.weight(1f),
                  onClick = {

                  }
               )
            }
            if(rowItem.size == 1){
               Spacer(modifier = Modifier.weight(1f))
            }

         }
      }
   }
}
//@Preview(showBackground = true)
//@Composable
//fun PreviewHome(){
//   Home()
//}