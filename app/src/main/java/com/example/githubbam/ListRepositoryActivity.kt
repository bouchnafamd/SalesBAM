package com.example.githubbam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.githubbam.presenters.ListRepositoryController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListRepositoryActivity : AppCompatActivity() {
    private lateinit var listRepositoryController : ListRepositoryController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listRepositoryController= ListRepositoryController()
        lifecycleScope.launch {
            val listRepo = listRepositoryController.getListRepository()
            withContext(Dispatchers.Main){

            }
        }
    }
}