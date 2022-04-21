package com.mesum.market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mesum.market.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpBottomBar()

    }

    private fun setUpBottomBar() {
        val bottomNavigationView : BottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(object: BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.menu_home ->{
                        Toast.makeText(this@MainActivity, "Home", Toast.LENGTH_SHORT).show()
                    }
                    R.id.menu_fav ->{
                        Toast.makeText(this@MainActivity, "Favourite", Toast.LENGTH_SHORT).show()
                    }
                    R.id.menu_place_add ->{
                        Toast.makeText(this@MainActivity, "Add", Toast.LENGTH_SHORT).show()
                    }
                    R.id.menu_profile -> {
                        Toast.makeText(this@MainActivity, "User", Toast.LENGTH_SHORT).show()
                    }
                }
                return true
            }

        })
    }


}