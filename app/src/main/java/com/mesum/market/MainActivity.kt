package com.mesum.market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mesum.market.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private  var marketData  = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpBottomBar()
        for (i in 0 until 10){
            marketData.add("Product ${i.toString()}")
        }

        setupRecyclerView()


    }

    class RvViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    }

    fun setupRecyclerView(){
        val recyclerViewAdapter = object  : RecyclerView.Adapter<RvViewHolder>(){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
                return  RvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false))
            }

            override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
                holder.itemView.findViewById<TextView>(R.id.product_text).text = marketData[position]
            }

            override fun getItemCount(): Int {
                return  marketData.size
            }

        }
        val recyclerView : RecyclerView = binding.recyclerViewRent
        recyclerView.adapter = recyclerViewAdapter
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