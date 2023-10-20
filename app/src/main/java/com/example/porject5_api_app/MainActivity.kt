package com.example.porject5_api_app

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var heroName: TextView
    private lateinit var heroDescrip: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView = findViewById(R.id.hero_recycleView)

        val dividerDrawable = ContextCompat.getDrawable(this, R.drawable.devider)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        if (dividerDrawable != null) {
            dividerItemDecoration.setDrawable(dividerDrawable)
        }

        recyclerView.addItemDecoration(dividerItemDecoration)






        MarvelFacts()

    }


    private fun MarvelFacts() {
        val client = AsyncHttpClient()
        val hash = "9edeba7e2947c9ecbb5a74a641f26887"
        val timestamp = "1697305844639"
        val publicKey = "34550754c7276728ef493df73a930470"

        val limit = 100
        val orderBy = "name"



        client.get("https://gateway.marvel.com:443/v1/public/characters?ts=${timestamp}&apikey=${publicKey}&hash=${hash}&orderBy=${orderBy}&limit=${limit}", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {

                Log.d("marvel", "Response successful")
                Log.d("marvel", "Image URL: ")


                val dataObject = json.jsonObject
                val data = dataObject.getJSONObject("data")
                val heroArray = data.getJSONArray("results")

                val heroList = mutableListOf<Heroes>()

                for (i in 0 until heroArray.length()) {
                    val heroObject = heroArray.getJSONObject(i)
                    val thumbnail = heroObject.getJSONObject("thumbnail")
                    var image = "${thumbnail.getString("path")}.${thumbnail.getString("extension")}"
                    image = image.replace("http://", "https://")
                    val name = heroObject.getString("name")
                    var description = heroObject.getString("description")
                    if(description.isEmpty()){
                        description = "No Description for this hero"
                    }

                    val hero = Heroes(image, name, description)
                    heroList.add(hero)
                }

                // Now, heroList contains a list of Hero objects with image, name, and description.
                for (hero in heroList) {
                    Log.d("hero", "Image: ${hero.image}, Name: ${hero.name}, Description: ${hero.description}")
                }

                recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView?.adapter = MarvelAdpater(heroList)


                }


            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("marvel Error", errorResponse)
                // Handle the error response here
            }
        })
    }



}