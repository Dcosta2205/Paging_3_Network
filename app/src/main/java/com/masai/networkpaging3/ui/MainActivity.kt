package com.masai.paging3.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.networkpaging3.R
import com.masai.networkpaging3.ui.CharacterAdapter
import com.masai.networkpaging3.ui.CharacterViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        setAdapter()
        characterViewModel.searchResults().observe(this, {
            lifecycleScope.launch {
                it?.let {
                    /*
                    Submit the data to the pager Adapter
                     */
                    characterAdapter.submitData(lifecycle, it)
                }
            }
        })
    }

    private fun setAdapter() {
        characterAdapter = CharacterAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.apply {
            layoutManager = linearLayoutManager
            this.adapter = characterAdapter
        }
    }
}