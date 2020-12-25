package com.example.githubbam.apis.services

import com.example.githubbam.apis.models.GitHubRepoListJson
import retrofit2.http.GET

interface GitHubService {
    @GET("orgs/bamlab/repos")
    suspend fun getBAMRepos() : GitHubRepoListJson
}