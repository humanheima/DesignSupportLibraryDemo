package com.example.designsupportlibrarydemo

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val TAG = "MainActivity"

    val titles: ArrayList<String> = arrayListOf("Spring", "Summer", "autumn", "winter")
    val fragments: ArrayList<Fragment> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        NavigationView.setNavigationItemSelectedListener(object : NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                item.isChecked = true
                val title = item.title.toString()
                Toast.makeText(this@MainActivity, title, Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawers()
                return true
            }
        })
        initViewPager()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(Gravity.START)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun initViewPager() {
        for (title in titles) {
            tabLayout.addTab(tabLayout.newTab().setText(title))
        }
        fragments.add(SpringFragment.newInstance())
        fragments.add(SpringFragment.newInstance())
        fragments.add(SpringFragment.newInstance())
        fragments.add(SpringFragment.newInstance())

        val fragmentAdapter = FragmentAdapter(supportFragmentManager, fragments, titles)
        viewpager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewpager)


    }


}
