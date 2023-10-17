package com.example.porject5_api_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val enterButton = findViewById<Button>(R.id.enterButton)
        val image = findViewById<ImageView>(R.id.imageS)
        var hero = findViewById<EditText>(R.id.charName)
        val heroDescription = findViewById<TextView>(R.id.description)
        val displayedName = findViewById<TextView>(R.id.displayedName)


        enterButton.setOnClickListener(){
            var heroName =hero.text.toString()
            MarvelFacts(image,heroName, heroDescription, displayedName)
        }

    }


    private fun MarvelFacts( imageView: ImageView,name: String, description: TextView, displayedName: TextView) {
        val client = AsyncHttpClient()
        val hash = "9edeba7e2947c9ecbb5a74a641f26887"
        val timestamp = "1697305844639"
        val privateKey = "34550754c7276728ef493df73a930470"



        client.get("https://gateway.marvel.com:443/v1/public/characters?ts=${timestamp}&apikey=${privateKey}&hash=${hash}&name=${name}", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("marvel", "Response successful")
                Log.d("marvel", "Image URL: ")



                if (json.jsonObject.has("data")) {
                    val data = json.jsonObject.getJSONObject("data")

                    if (data.has("results") && data.getJSONArray("results").length() > 0) {
                        val resultJSON = data.getJSONArray("results").getJSONObject(0) // Assuming the first result is the character you want

                        if (resultJSON.has("thumbnail")) {
                            val thumbnail = resultJSON.getJSONObject("thumbnail")
                            val path = thumbnail.getString("path")
                            Log.d("path", "$path")
                            val extension = thumbnail.getString("extension")

                            // Combine path and extension to get the full image URL
                            var superHeroImage = "$path.$extension"
                            Log.d("marvel", "Image URL: $superHeroImage")
                            superHeroImage = superHeroImage.replace("http://", "https://")

                            // Load the image into your ImageView
                            Glide.with(imageView.context)
                                .load(superHeroImage)
                                .fitCenter()
                                .into(imageView)

                        }
                        if (resultJSON.has("description")) {
                            val descriptionValue = resultJSON.getString("description")

                            // Set the description value to your TextView
                            description.text = descriptionValue
                        }
                        if (resultJSON.has("name")) {
                            val descriptionValue = resultJSON.getString("name")

                            // Set the description value to your TextView
                            displayedName.text = descriptionValue
                        }

                     }
                    }

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