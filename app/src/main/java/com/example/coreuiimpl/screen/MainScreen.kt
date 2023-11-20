//package com.example.coreuiimpl.screen
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.layout.wrapContentHeight
//import androidx.compose.foundation.layout.wrapContentWidth
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//import coil.compose.rememberImagePainter
//import coil.transform.CircleCropTransformation
//import coil.transform.GrayscaleTransformation
//import com.example.coreuiimpl.model.UserProfile
//import com.example.coreuiimpl.viewmodel.MainViewModel
//import com.example.coreuiimpl.theme.MyTheme
//import com.example.coreuiimpl.model.userProfileList
//
//val namesList: ArrayList<String> = arrayListOf("John", "Bola", "Dami", "Lola", "Biola")
//
//class MainScreen : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyTheme {
//                UsersApplication()
//            }
//        }
//    }
//}
//
//@Composable
//fun UsersApplication(userProfiles: List<UserProfile> = userProfileList) {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "user_list") {
//        composable("user_list") {
//            UserListScreen(userProfiles, navController)
//        }
//        composable(route = "user_details/{userId}",
//            arguments = listOf(navArgument("userId") {
//                type = NavType.IntType
//            })
//        ) { navBackStackEntry ->
//            UserProfileDetailsScreen(navBackStackEntry.arguments!!.getInt("userId"), navController)
//        }
//    }
//}
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun UserListScreen(userProfiles: List<UserProfile>, navController: NavHostController?) {
//    Scaffold(
//        topBar = {
//            AppBar(
//                title = "Users List",
//                icon = Icons.Default.Home
//            ) { }
//            Row(
//                Modifier
//                    .fillMaxWidth()
//                    .height(65.dp)
//            ) {
//                Box(modifier = Modifier.fillMaxSize())
//            }
//        },
//        content = {
//            Surface(
//                modifier = Modifier.fillMaxSize(),
//                color = Color.White
//            ) {
//                LazyColumn {
//                    items(userProfiles) { userProfile ->
//                        ProfileCard(userProfile = userProfile) {
//                            navController?.navigate("user_details/${userProfile.id}")
//                        }
//                    }
//                }
////            Column {
////                for (userProfile in userProfiles)
////                ProfileCard(userProfile = userProfile)
////            }
//            }
//        }
//    )
//}
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun UserProfileDetailsScreen(userId: Int, navController: NavHostController?) {
//    val userProfile = userProfileList.first { userProfile -> userId == userProfile.id }
//    Scaffold(
//        topBar = {
//            AppBar(
//                title = "User Profile Details",
//                icon = Icons.Default.ArrowBack
//            ) {
//                navController?.navigateUp()
//            }
//            Row(
//                Modifier
//                    .fillMaxWidth()
//                    .height(65.dp)
//            ) {
//                Box(modifier = Modifier.fillMaxSize())
//            }
//        },
//        content = {
//            Surface(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(top = 60.dp),
//                color = Color.White
//            ) {
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Top
//                ) {
//                    ProfilePicture(userProfile.pictureUrl, userProfile.status, 250.dp)
//                    ProfileContent(
//                        userProfile.name,
//                        userProfile.status,
//                        Alignment.CenterHorizontally
//                    )
//                }
//            }
//        }
//    )
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ScaffoldWithTopBar() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "Top App Bar")
//                },
//                navigationIcon = {
//                    IconButton(onClick = {}) {
//                        Icon(Icons.Filled.ArrowBack, "backIcon")
//                    }
//                },
//                colors = TopAppBarDefaults.smallTopAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primary,
//                    titleContentColor = Color.White,
//                ),
//            )
//        },
//        content = {
//            Column(
//                modifier = Modifier
//                    .padding(it)
//                    .fillMaxSize()
//                    .background(Color(0xff8d6e63)),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Content of the page",
//                    fontSize = 30.sp,
//                    color = Color.White
//                )
//            }
//        })
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppBar(title: String, icon: ImageVector, iconClickAction : () -> Unit) {
//    TopAppBar(
//        modifier = Modifier.fillMaxWidth(),
//        navigationIcon = {
//            Icon(
//                imageVector = icon,
//                "content description",
//                modifier = Modifier.padding(horizontal = 12.dp)
//                    .clickable (onClick = { iconClickAction.invoke() })
//            )
//        },
//        title = {
//            Text(
//                title,
//                style = MaterialTheme.typography.headlineSmall
//            )
//        },
//        colors = TopAppBarDefaults.smallTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primary,
//            navigationIconContentColor = Color.White,
//            titleContentColor = Color.White,
//        )
//    )
//}
//
//@Composable
//fun ProfileCard(userProfile: UserProfile, clickAction: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .clickable(onClick = { clickAction.invoke() }),
//        colors = CardDefaults.cardColors(Color.White),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
//        border = BorderStroke(
//            width = 1.dp,
//            color = Color.LightGray
//        )
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            ProfilePicture(userProfile.pictureUrl, userProfile.status, 72.dp)
//            ProfileContent(userProfile.name, userProfile.status, alignment = Alignment.Start)
//        }
//    }
//}
//
//@Composable
//fun ProfilePicture(pictureUrl: String, onlineStatus: Boolean, imageSize: Dp) {
//    Card(
//        shape = CircleShape,
//        border = BorderStroke(
//            width = 1.dp,
//            color = if (onlineStatus) Color.Green
//            else Color.Red
//        ),
//        modifier = Modifier.padding(16.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//    ) {
//        val painter = if (onlineStatus) {
//            rememberImagePainter(data = pictureUrl)
//        } else {
//            rememberImagePainter(data = pictureUrl,
//                builder = {
//                    transformations(
//                        GrayscaleTransformation(), //Gray Scale Transformation
//                        CircleCropTransformation() //Circle Crop Transformation
//                    )
//                })
//        }
//
//        Image(
//            painter = painter,
//            modifier = Modifier.size(imageSize),
//            contentScale = ContentScale.Crop,
//            contentDescription = "Profile Image"
//        )
//    }
//}
//
//@Composable
//fun ProfileContent(userName: String, onlineStatus: Boolean, alignment: Alignment.Horizontal) {
//    Column(
//        modifier = Modifier
//            .padding(8.dp)
//            .wrapContentWidth(),
//        horizontalAlignment = alignment
//    ) {
//        Text(
//            text = userName,
//            style = MaterialTheme.typography.headlineSmall,
//            color = Color.Black
//        )
//        Text(
//            text = if (onlineStatus) "Active now"
//            else "Offline",
//            style = MaterialTheme.typography.bodyMedium,
//            color = Color.DarkGray
//        )
//    }
//}
//
//@Composable
//fun Main() {
//    Surface(
//        color = Color.DarkGray,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Column(
//            Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.SpaceEvenly,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Row(
//                Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                ColoredSquare(Color.Green)
//                ColoredSquare(Color.White)
//            }
//            ColoredSquare(Color.Green)
//            ColoredSquare(Color.White)
//            ColoredSquare(Color.Green)
//        }
//    }
//}
//
//@Composable
//fun MainScrn(viewModel: MainViewModel = MainViewModel()) {
//    //val greetingListState = remember {mutableStateListOf<String>("John", "Amanda")}
//    //val newNameStateContent = remember { mutableStateOf("") }
//
//    val newNameStateContent = viewModel.textFieldState.observeAsState("")
//
//    Column(
//        modifier = Modifier
//            .padding(20.dp)
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.SpaceEvenly,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        GreetingMessage(//greetingListState,
//            //{ greetingListState.add(newNameStateContent.value) },
//            newNameStateContent.value
//        ) { newName -> viewModel.onTextChanged(newName) }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun GreetingMessage(
//    textFieldValue: String,
//    textFieldUpdate: (newName: String) -> Unit
//) {
//
//    TextField(value = textFieldValue, onValueChange = textFieldUpdate)
//    Button(onClick = { }) {
//        Text(text = textFieldValue)
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun GreetingList(
//    nameList: List<String>,
//    buttonClick: () -> Unit,
//    textFieldValue: String,
//    textFieldUpdate: (newName: String) -> Unit
//) {
//
//    for (name in nameList) {
//        Greeting(name = name)
//    }
//
//    TextField(value = textFieldValue, onValueChange = textFieldUpdate)
//
//    Button(onClick = buttonClick) {
//        Text(text = "Add new name")
//    }
//}
//
//@Composable
//fun Greeting(name: String) {
//    Text(
//        text = "Hello $name!",
//        color = Color.DarkGray,
//        style = MaterialTheme.typography.headlineSmall
//    )
//}
//
//@Composable
//fun ColoredSquare(color: Color) {
//    Surface(
//        color = color,
//        modifier = Modifier
//            .height(100.dp)
//            .width(100.dp)
//    ) {
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun UserListPreview() {
//    MyTheme {
//        UserListScreen(userProfiles = userProfileList, null)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun UserProfileDetailsPreview() {
//    MyTheme {
//        UserProfileDetailsScreen(userId = 0, null)
//    }
//}