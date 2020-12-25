package com.example.githubbam

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.example.githubbam.adapters.ListRepositoryAdapter
import com.example.githubbam.presenters.ListRepositoryController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ListRepositoryActivity : AppCompatActivity() {
    private lateinit var listRepositoryController : ListRepositoryController
    private lateinit var listRepositoryAdapter : ListRepositoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listRepositoryController= ListRepositoryController()
        listRepositoryAdapter= ListRepositoryAdapter(this)
        repoListView.adapter=listRepositoryAdapter
        fetchListRepository()
        swipeLayout.setOnRefreshListener {
            fetchListRepository()
        }
    }

    private fun fetchListRepository(){
        lifecycleScope.launch {
            loadingView.visibility= View.VISIBLE
            try {
                val listRepo = listRepositoryController.getListRepository()
                listRepositoryAdapter.update(listRepo)
            }catch (exception : Exception){
                showDialog(exception)
            }finally {
                loadingView.visibility= View.GONE
                swipeLayout.isRefreshing=false
            }
        }
    }

    private fun showDialog(exception: Exception){
        val builder = AlertDialog.Builder(this)
        builder.setMessage(exception.localizedMessage)
            .setPositiveButton(R.string.btn_ok
            ) { dialog, id ->
                finish()
            }
        // Create the AlertDialog object and return it
        builder.create().show()
    }
}