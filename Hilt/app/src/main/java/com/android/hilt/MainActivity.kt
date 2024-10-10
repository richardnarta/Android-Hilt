package com.android.hilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.hilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        displayText()
    }

    private fun displayText() {
        binding.apply {
            tvRepo1.text = viewModel.firstMessage
            tvRepo2.text = viewModel.secondMessage
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}