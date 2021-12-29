package com.tomuchcoffee.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tomuchcoffee.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        binding.btnCalculate.setOnClickListener {
            val width = binding.edtWidth.text.toString()
            val height = binding.edtHeight.text.toString()
            val length = binding.edtLength.text.toString()

            when {
                width.isEmpty() -> {
                    binding.edtWidth.error = "Masih kosong"
                }
                height.isEmpty() -> {
                    binding.edtHeight.error = "Masih kosong"
                }
                length.isEmpty() -> {
                    binding.edtLength.error = "Masih kosong"
                }
                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
       binding.tvResult.text = viewModel.result.toString()
    }
}