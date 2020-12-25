package com.example.githubbam.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubbam.R
import com.example.githubbam.apis.models.GitHubRepoListJsonItem
import kotlinx.android.synthetic.main.item_repo_list.view.*

class ListRepositoryAdapter ( val mContext : Context) :
    RecyclerView.Adapter<ListRepositoryAdapter.ItemViewHolder>() {
    var listRepo = ArrayList<GitHubRepoListJsonItem>()
    class ItemViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val nameText = view.nameText
        val fullNameText = view.fullNameText
        val ownerText = view.ownerText
        val descriptionText = view.descriptionText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_repo_list,parent,false))

    override fun getItemCount() = listRepo.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listRepo[position]
        holder.nameText.text = mContext.getString(R.string.repo_name,item.name)
        holder.descriptionText.text = mContext.getString(R.string.repo_description,item.description)
        holder.fullNameText.text = mContext.getString(R.string.repo_fullname,item.fullName)
        holder.ownerText.text = mContext.getString(R.string.repo_owner,item.owner?.login)
    }

    fun update(listRepo : ArrayList<GitHubRepoListJsonItem>){
        this.listRepo=listRepo
        notifyDataSetChanged()
    }
}