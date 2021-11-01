package com.example.android.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.android.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(
                binding.boxOneText,
                binding.boxTwoText,
                binding.boxThreeText,
                binding.boxFourText,
                binding.boxFiveText,
                binding.constraintLayout
            )

        for (item in clickableViews){
            item.setOnClickListener { makeColoured(it)}
        }
    }

    private fun makeColoured(view: View) {
        when (view.id) {
            // Boxes using Color class colors for background
            binding.boxOneText.id -> view.setBackgroundColor(Color.DKGRAY)
            binding.boxTwoText.id -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            binding.boxThreeText.id -> view.setBackgroundResource(android.R.color.holo_green_light)
            binding.boxFourText.id -> view.setBackgroundResource(android.R.color.holo_green_dark)
            binding.boxFiveText.id -> view.setBackgroundResource(android.R.color.holo_green_light)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}