package com.example.keepitchecked

import android.app.ActionBar
import android.os.Bundle
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.keepitchecked.databinding.ActivityMainBinding
import pl.droidsonroids.gif.GifImageView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)

    } // end of OnCreate
}


    /*fun HomePage() {
        /* FUNCTIONS OF HOME PAGE */
        val btnSubmit = findViewById<Button>(R.id.btn_home_submit)
        val radioGroup = findViewById<RadioGroup>(R.id.home_radioGroup)
        val textView = findViewById<TextView>(R.id.home_response)
        val userName = findViewById<EditText>(R.id.home_name)
        val gifResponse = findViewById<GifImageView>(R.id.gif_home_response)
        // home_button
        btnSubmit.setOnClickListener {
            var radioButton = radioGroup.checkedRadioButtonId
            var mood = findViewById<RadioButton>(radioButton)
            var name = userName.getText().toString()
            // Make sure a button is checked
            if (radioButton == -1 || name == "") {
                textView.setText("Complete all the inputs first 😅")
                //textView.setText("Hi" + name)
            } else if (mood.text == "I'm great"){

                textView.setText("Hi "+name+"! I'm happy to know that you are feeling well")
                gifResponse.setImageResource(R.drawable.happy_res)
                gifResponse.layoutParams.width = 800
                gifResponse.layoutParams.height = 550
                gifResponse.setScaleType(ImageView.ScaleType.FIT_XY)
            }
            else {
                textView.setText("Hi "+name+"! I'm sorry to hear that!")
                gifResponse.setImageResource(R.drawable.sad_res)
                gifResponse.layoutParams.width = 800
                gifResponse.layoutParams.height = 550
                gifResponse.setScaleType(ImageView.ScaleType.FIT_XY)
            }

        }
    }*/