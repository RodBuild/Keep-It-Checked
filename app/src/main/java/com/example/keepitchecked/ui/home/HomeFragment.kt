package com.example.keepitchecked.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.UserManager
import android.provider.Settings.Global.putString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.createDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.keepitchecked.R
import com.example.keepitchecked.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import pl.droidsonroids.gif.GifImageView
import java.util.prefs.Preferences

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /* FUNCTIONS OF HOME PAGE */
        val btnSubmit = root.findViewById<Button>(R.id.btn_home_submit)
        val radioGroup = root.findViewById<RadioGroup>(R.id.home_radioGroup)
        val textView = root.findViewById<TextView>(R.id.home_response)
        val userName = root.findViewById<EditText>(R.id.home_name)
        val gifResponse = root.findViewById<GifImageView>(R.id.gif_home_response)

        // home_button
        btnSubmit.setOnClickListener {
            var radioButton = radioGroup.checkedRadioButtonId
            var mood = root.findViewById<RadioButton>(radioButton)
            var name = userName.getText().toString()
            // Store data in class
            homeViewModel.set_name(name)

            // Make sure a button is checked
            if (radioButton == -1 || name == "") {
                textView.setText("Complete all the inputs first 😅")
                //textView.setText("Hi" + name)
            } else if (mood.text == "I'm great"){
                homeViewModel.set_mood("good")
                textView.setText("Hi "+name+"! I'm happy to know that you are feeling well")
                gifResponse.setImageResource(R.drawable.happy_res)
                gifResponse.layoutParams.width = 800
                gifResponse.layoutParams.height = 550
                gifResponse.setScaleType(ImageView.ScaleType.FIT_XY)
            }
            else {
                homeViewModel.set_mood("bad")
                textView.setText("Hi "+name+"! I'm sorry to hear that!")
                gifResponse.setImageResource(R.drawable.sad_res)
                gifResponse.layoutParams.width = 800
                gifResponse.layoutParams.height = 550
                gifResponse.setScaleType(ImageView.ScaleType.FIT_XY)
            }
        }

        //val textView: TextView = binding.textHome
        /*homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        return root
    }
}