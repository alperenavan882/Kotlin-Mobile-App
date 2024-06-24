package com.alperenavan.superherobook

import android.content.Intent
import android.graphics.BitmapFactory
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PresentationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation)

        val intent = intent
        val choosensupCharacterName = intent.getStringExtra("supCharacterName")

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = choosensupCharacterName

        var imageView = findViewById<ImageView>(R.id.imageView)

        val choosenCharacterPicture = intent.getIntExtra("supCharacterPicture" , 0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources , choosenCharacterPicture)


        imageView.setImageBitmap((bitmap))

        //val choosenCharacter = SingletonClass.choosenCharacter
        //val choosenPicture = choosenCharacter.picture
        //var imageView = findViewById<ImageView>(R.id.imageView)
        //imageView.setImageBitmap(choosenPicture)
    }
}