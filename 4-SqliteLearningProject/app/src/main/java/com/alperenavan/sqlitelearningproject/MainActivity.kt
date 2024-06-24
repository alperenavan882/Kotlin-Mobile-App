package com.alperenavan.sqlitelearningproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //try catch

        try{

            val dataBase = this.openOrCreateDatabase("Products" , MODE_PRIVATE , null)

            dataBase.execSQL("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY , name VARCHAR , price INT)")
            //dataBase.execSQL("INSERT INTO products(name , price) VALUES('Shirt' , 100)")
            //dataBase.execSQL("INSERT INTO products(name , price) VALUES('Jacket' , 500)")
            //dataBase.execSQL("INSERT INTO products(name , price) VALUES('Short' , 150)")
            //dataBase.execSQL("INSERT INTO products(name , price) VALUES('Trousers' , 300)")

            //dataBase.execSQL("DELETE FROM products WHERE id = 2")

            dataBase.execSQL("UPDATE products SET price = 200 WHERE name = 'Short'")

            val cursor = dataBase.rawQuery("SELECT * FROM products" , null )
            //val cursor = dataBase.rawQuery("SELECT * FROM products WHERE name = 'Short'" , null )
            //val cursor = dataBase.rawQuery("SELECT * FROM products WHERE id = 3  " , null )
            //val cursor = dataBase.rawQuery("SELECT * FROM products WHERE name LIKE '%t'  " , null ) //If you put the letter at the and of % that means find the ones which has that letter but if you put before that means just find that word which starts with that letter

            val idColumnIndex = cursor.getColumnIndex("id")
            val nameColumnIndex = cursor.getColumnIndex("name")
            val priceColumnIndex = cursor.getColumnIndex("price")

            while (cursor.moveToNext()){
                println("ID : ${cursor.getInt(idColumnIndex)}")
                println("Name : ${cursor.getString(nameColumnIndex)}")
                println("Price : ${cursor.getInt(priceColumnIndex)}")

            }

            cursor.close()

        }catch(e: Exception){
            e.printStackTrace()
        }

    }



}