package com.example.moneytips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneytips.databinding.ActivityMainBinding
import java.text.NumberFormat

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{ calculateTip() }

//        binding.myButton.text = "A button"
    }
    fun calculateTip(){

        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> .20
            R.id.option_eighteen_percent -> .18
            R.id.option_fifteen_percent -> .15
            else -> 0.0

        }
            var tip = tipPercentage + (tipPercentage * cost)
        val roundup = binding.roundUpSwitch.isChecked

        if (roundup){
            tip = kotlin.math.ceil(tip)
        }
      val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text= getString(R.string.tip_amount, formattedTip)

    }
}

