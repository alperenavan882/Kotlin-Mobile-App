package com.alperenavan.superherobook

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.alperenavan.superherobook.databinding.RecyclerRowBinding

class RecyclerAdapter(val characterList : ArrayList<String> , val characterPictures : ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapter.CharactersVH>() {
    class CharactersVH(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersVH {
        //Inflater , LayoutInflater , MenuInflater
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context) , parent , false)


        //val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row , parent , false)
        //return CharactersVH(itemView)

        return CharactersVH(binding)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharactersVH, position: Int) {
            holder.binding.recyclerViewTextView.text = characterList.get(position)
            holder.itemView.setOnClickListener{
                val intent = Intent(holder.itemView.context , PresentationActivity::class.java)
                intent.putExtra("supCharacterName" , characterList.get(position) )
                intent.putExtra("supCharacterPicture" , characterPictures.get(position))

                //val singleton = SingletonClass.choosenCharacter

                //singleton.picture = supCharacterPictures.get(position)

                holder.itemView.context.startActivity(intent)
            }

        //holder.itemView.recyclerViewTextView.
        //it was an old method so we used viewBinding method.
    }


}