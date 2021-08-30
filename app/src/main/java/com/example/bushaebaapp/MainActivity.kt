package com.example.bushaebaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.biottomnavigationkt.HomeFragment
import com.example.biottomnavigationkt.PersonalFragment
import com.example.biottomnavigationkt.SettingFragment
import kotlinx.android.synthetic.main.dashboard.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
        supportActionBar?.hide()

        val firstFragment= PersonalFragment()
        val secondFragment= HomeFragment()
        val thirdFragment= SettingFragment()

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.person->setCurrentFragment(secondFragment)
                R.id.settings->setCurrentFragment(thirdFragment)

            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.lframelayout,fragment)
            commit()
        }
}