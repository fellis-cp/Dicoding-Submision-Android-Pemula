package com.dicoding.subs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import android.view.Menu
import android.view.MenuItem

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val girlName = intent.getStringExtra("girlName")
        val girlDescription = intent.getStringExtra("girlDescription")
        val girlPhotoResId = intent.getIntExtra("girlPhoto", R.drawable.alim)

        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)

        imgPhoto.setImageResource(girlPhotoResId)
        tvName.text = girlName
        tvDescription.text = girlDescription
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> {
                val CharacterName = intent.getStringExtra("CharacterName")
                val CharacterDescription = intent.getStringExtra("CharacterDescription")
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Character Name : " + CharacterName + "\n Character Description : " + CharacterDescription)
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


}
