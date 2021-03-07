package com.mczuba.covidwpolsce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.liveData
import androidx.navigation.fragment.NavHostFragment
import com.mczuba.covidwpolsce.api.CovidDataProvider
import com.mczuba.covidwpolsce.data.CountryHistory
import com.mczuba.covidwpolsce.vm.PrepareFragmentDirections
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import me.ibrahimsn.lib.SmoothBottomBar
import net.danlew.android.joda.JodaTimeAndroid
import org.joda.time.DateTime
import java.util.*
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {
    private lateinit var navView: SmoothBottomBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        JodaTimeAndroid.init(this)
        navView = findViewById(R.id.nav_view)
        navView.visibility = View.INVISIBLE

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val menu = PopupMenu(this@MainActivity, null).menu
        menuInflater.inflate(R.menu.menu_nav_menu, menu)
        navView.setupWithNavController(menu!!, navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id)
            {
                R.id.navigation_prepare -> navView.visibility = View.GONE
                else -> navView.visibility = View.VISIBLE
            }
        }
    }
}