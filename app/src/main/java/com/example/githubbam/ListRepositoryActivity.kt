package com.example.githubbam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.githubbam.adapters.ListRepositoryAdapter
import com.example.githubbam.presenters.ListRepositoryController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListRepositoryActivity : AppCompatActivity() {
    private lateinit var listRepositoryController : ListRepositoryController
    private lateinit var listRepositoryAdapter : ListRepositoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listRepositoryController= ListRepositoryController()
        listRepositoryAdapter= ListRepositoryAdapter(this)
        repoListView.adapter=listRepositoryAdapter
        lifecycleScope.launch {
            loadingView.visibility= View.VISIBLE
            val listRepo = listRepositoryController.getListRepository()
            loadingView.visibility= View.GONE
            listRepositoryAdapter.update(listRepo)
        }
    }
}