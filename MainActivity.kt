package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener { roundTip() }

    }
    private fun roundTip() {
        val stringInTextField = binding.etCostOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val tipPercentage = when(binding.rgTipOptions.checkedRadioButtonId) {
            R.id.rbtn_awesome -> 0.20
            R.id.rbtn_good -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        if(binding.swTipRoundOf.isChecked) {
            binding.tvResult.text = NumberFormat.getCurrencyInstance().format(kotlin.math.ceil(tip)).toString()
        }else {
            binding.tvResult.text = "Tip amount:" + "${NumberFormat.getCurrencyInstance().format(tip).toString()}"
        }
    }
}