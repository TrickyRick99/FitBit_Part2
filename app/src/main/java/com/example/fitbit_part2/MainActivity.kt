package com.example.fitbit_part2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitbit_part2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


public lateinit var db: AppDatabase
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drinkRecycler: RecyclerView

    private var drinkSet = listOf<Drink>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db= AppDatabase.getDatabase(this)

        replaceFragment(DrinkLogFragment())
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
//        drinkRecycler=findViewById(R.id.drinkRec)
//
//        GlobalScope.launch(Dispatchers.IO){
//
//            val drinkSet = db.drinkDao().getAll()
//
//            val adapter = DrinkAdapter( drinkSet)
//            drinkRecycler.adapter = adapter
//
//
//
//
//        }
//        drinkRecycler.layoutManager = LinearLayoutManager(this)
        bottomNavigationView.setOnItemSelectedListener {
                item ->
            lateinit var fragment: Fragment
            when(item.itemId){
                R.id.logNav -> fragment = DrinkLogFragment()
                R.id.dashNav -> fragment = DrinkDashFragment()

            }
            replaceFragment(fragment)
            Log.v("Fragment",fragment.toString())

            true
        }
    }


    private fun replaceFragment(fragSwitch: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragSwitch)
        fragmentTransaction.commit()
    }
}