package com.example.lesson2app_last

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson2app_last.databinding.ItemRvBinding
import com.example.lesson2app_last.Character

class CharacterAdapter(private val onItemClick: OnItemClick) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    private var data: ArrayList<Character> = ArrayList()

    fun setData(data: ArrayList<Character>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        data.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent,false))

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnLongClickListener{
            onItemClick.openAlertDialog(position)
            true
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class CharacterViewHolder(val binding: ItemRvBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(character: Character){
            binding.tvName.text = character.name
            binding.ivImage.loadImage(character.image.toString())

            //Glide.with(binding.root).load(character.image).into(binding.image)

        }

    }
}