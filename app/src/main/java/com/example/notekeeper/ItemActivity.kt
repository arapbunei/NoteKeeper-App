package com.example.notekeeper

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notekeeper.databinding.ActivityItemBinding
import kotlinx.android.synthetic.main.content_item.*

class ItemActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_item)

        setSupportActionBar(binding.appBarItem.toolbar)

        binding.appBarItem.fab.setOnClickListener { view ->
                startActivity(Intent(this,MainActivity::class.java))
        }

        listItems.layoutManager = LinearLayoutManager(this)
        listItems.adapter = NoteRecyclerAdapter(this,DataManager.notes)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        //val navController = findNavController(R.id.nav_host_fragment_content_item)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
       // navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        listItems.adapter?.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.item, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
       // val navController = findNavController(R.id.nav_host_fragment_content_item)
        return super.onSupportNavigateUp()
    }
}