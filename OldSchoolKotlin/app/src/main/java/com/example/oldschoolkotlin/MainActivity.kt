package com.example.oldschoolkotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.oldschoolkotlin.databinding.ActivityMainBinding
//open class Base(x : Int) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other !is Base) return false
//        return true
//    }
//
//    override fun hashCode(): Int {
//        return javaClass.hashCode()
//    }
//}
//
//// operator-() {...}
//// if (base1 == base2)  (base1.equals(base2) in Java)
//// if (base1 === base2)
//
//open class Base1 constructor(xVal : Int) {
//    var x : Int = xVal;
//}
//
//class Derive(xVal : Int, zVal : Int?) : Base(xVal) {
//    var y : Int = defaultVal(zVal, 0);
//}
//
//fun defaultVal(x : Int?, defX : Int) : Int {
//    if (x != null) return x;
//    return defX;
//}
//
//class WeatherAPI{};

class MainActivity : AppCompatActivity() {

//    val weatherAPI : WeatherAPI by lazy {WeatherAPI();}

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}