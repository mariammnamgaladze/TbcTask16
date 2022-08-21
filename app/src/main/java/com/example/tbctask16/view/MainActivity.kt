package com.example.tbctask16.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tbctask16.databinding.ActivityMainBinding
import com.example.tbctask16.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val singleUserAdapter by lazy { MyAdapter() }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        observerer()

    }

    private fun init() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = singleUserAdapter.withLoadStateFooter(
                footer = LoaderAdapter()
            )
        }
    }

    private fun observerer() {
        lifecycleScope.launch {
            viewModel.info().collect() {
                singleUserAdapter.submitData(it)
            }
        }
    }

}
