package com.example.anod_compose

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.anod_compose.ui.theme.Anod_ComposeTheme

class MainActivity : ComponentActivity() {
    var pref: SharedPreferences? = null
    var isNewUser = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE) //  create sharedpref TABLE
        CheckNewUser()
        Log.d("MainActivity", "After CheckNewUser")

        setContent {
            Anod_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }

    fun saveBooleanSharedPrefData(key: String, data: Boolean) {
        val editor = pref?.edit()
        editor?.putBoolean(key, data)
        editor?.apply()
    }

    fun CheckNewUser() {
        isNewUser = pref?.getBoolean("is_new_user",  false)!! // get boolean data from TABLE
        if (!isNewUser) {
            saveBooleanSharedPrefData("is_new_user", true) // put in the TABLE boolean data

            val intent = Intent(this, HelloActivity::class.java)
            startActivity(intent)
        }
    }
}


@Composable
fun MainView() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Anod_ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainView()
        }
    }
}