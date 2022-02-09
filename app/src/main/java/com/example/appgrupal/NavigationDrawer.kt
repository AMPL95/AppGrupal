package com.example.appgrupal

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.appgrupal.chat.Chat
import com.example.appgrupal.databinding.ActivityNavigationDrawerBinding

class NavigationDrawer : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar)

       /* binding.appBarNavigationDrawer.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_navigation_drawer)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home, R.id.nav_profile, R.id.nav_help,R.id.nav_conf), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    fun onClickPedirCita(view: View){
        val inicioIntent= Intent(this,Calendario::class.java)
        startActivity(inicioIntent)
    }
    fun onClickentrarChat(view: View){
        val inicioIntent= Intent(this, Chat::class.java)
        startActivity(inicioIntent)
    }
    fun onClickMisCitas(view: View){
        val inicioIntent= Intent(this, Miscitas::class.java)
        startActivity(inicioIntent)
    }

    fun onClickInformes(view: View){
        val inicioIntent= Intent(this, informes::class.java)
        startActivity(inicioIntent)
    }
    fun onClickEspecialista(view: View){
        val inicioIntent= Intent(this, Especialista::class.java)
        startActivity(inicioIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigation_drawer)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}