package com.example.githubbam.presenters

import android.util.Log
import com.example.githubbam.apis.RetrofitHelper
import com.example.githubbam.apis.models.GitHubRepoListJson
import com.example.githubbam.apis.services.GitHubService

class ListRepositoryController  {
    private val gitHubService = RetrofitHelper.retrofit.create(GitHubService::class.java)
    suspend fun getListRepository() : GitHubRepoListJson {
        val listRepo = gitHubService.getBAMRepos()
        return listRepo
    }
}