package com.example.a4kwallpapersapi.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a4kwallpapersapi.databinding.ItemRvBinding
import com.example.a4kwallpapersapi.models.Urls
import com.example.a4kwallpapersapi.modelsTwo.Movie
import com.squareup.picasso.Picasso

class RvAdapters(var list: ArrayList<Movie>, var onMyItemClickListener: OnMyItemClickListener) :
    RecyclerView.Adapter<RvAdapters.Vh>() {

    inner class Vh(var itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {

        fun onBind(urls: Movie, position: Int) {

            Picasso.get().load(urls.imageurl).into(itemRvBinding.imageRv)

            itemRvBinding.root.setOnClickListener {

                onMyItemClickListener.onItemClick(urls, position)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {

        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: Vh, position: Int) {

        holder.onBind(list[position], position)

    }

    override fun getItemCount(): Int {

        return list.size

    }

    interface OnMyItemClickListener {

        fun onItemClick(urls: Movie, position: Int)

    }

}