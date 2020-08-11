package com.example.dogs.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.model.DogBreedModel
import com.example.dogs.view.fragment.ListFragmentDirections
import kotlinx.android.synthetic.main.dogs_list_item.view.*

class DogBreedAdapter(val dogBreedList: ArrayList<DogBreedModel>) :
    RecyclerView.Adapter<DogBreedAdapter.DogBreedViewHolder>() {

    fun updateDogList(newDogList: List<DogBreedModel>) {
        dogBreedList.clear()
        dogBreedList.addAll(newDogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogBreedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.dogs_list_item, parent, false)
        return DogBreedViewHolder(view)
    }

    override fun getItemCount() = dogBreedList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DogBreedViewHolder, position: Int) {
        holder.view.dogName.text = dogBreedList[position].dogBreedName
        holder.view.shortDetails.text = dogBreedList[position].dogBreedDescription + " " + dogBreedList[position].dogTemperament
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.listFragmentToDetailsFragment())
        }
    }

    class DogBreedViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}