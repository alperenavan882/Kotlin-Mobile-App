package com.alperenavan.superherobook

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alperenavan.superherobook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //Data Preparation

        var supCharacterNames = ArrayList<String>()
        supCharacterNames.add("Batman")
        supCharacterNames.add("Loki")
        supCharacterNames.add("Thanos")
        supCharacterNames.add("Homelander")
        supCharacterNames.add("Joker")

        //Efficient way to define without Singleton method

        val batmanDrawableId = R.drawable.batman_new
        val lokiDrawableId = R.drawable.loki_new
        val thanosDrawableId = R.drawable.thanos_new
        val homelanderDrawableId = R.drawable.homelander_new
        val jokerDrawableId = R.drawable.joker_new

        var charactersDrawableList = ArrayList<Int>()
        charactersDrawableList.add(batmanDrawableId)
        charactersDrawableList.add(lokiDrawableId)
        charactersDrawableList.add(thanosDrawableId)
        charactersDrawableList.add(homelanderDrawableId)
        charactersDrawableList.add(jokerDrawableId)


        //Inefficient way to define with Singleton method

        //val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources , R.drawable.batman)
        //val lokiBitmap = BitmapFactory.decodeResource(applicationContext.resources , R.drawable.loki)
        //val thanosBitmap = BitmapFactory.decodeResource(applicationContext.resources , R.drawable.thanos)
        //val homelanderBitmap = BitmapFactory.decodeResource(applicationContext.resources , R.drawable.homelander)
        //val jokerBitmap = BitmapFactory.decodeResource(applicationContext.resources , R.drawable.joker)


        //var supCharacterPictures = ArrayList<Bitmap>()
        //supCharacterPictures.add(batmanBitmap)
        //supCharacterPictures.add(lokiBitmap)
        //supCharacterPictures.add(thanosBitmap)
        //supCharacterPictures.add(homelanderBitmap)
        //supCharacterPictures.add(jokerBitmap)

        //Adapter

        val layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager

        val adapter = RecyclerAdapter(supCharacterNames , charactersDrawableList)

        recyclerView.adapter = adapter


    }



}