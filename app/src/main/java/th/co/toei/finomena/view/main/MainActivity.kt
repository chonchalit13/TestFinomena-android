package th.co.toei.finomena.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import th.co.toei.finomena.R
import th.co.toei.finomena.databinding.ActivityMainBinding
import th.co.toei.finomena.view.fund.FundFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTabLayoutBottom()
        init()
    }

    private fun init() {
        replaceFragment(FundFragment.newInstance())

        binding.tabLayoutBottom.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        replaceFragment(FundFragment.newInstance())
                    }
                    1 -> {

                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun initTabLayoutBottom() {
        binding.tabLayoutBottom.addTab(binding.tabLayoutBottom.newTab().setText("Menu"))
        binding.tabLayoutBottom.addTab(binding.tabLayoutBottom.newTab().setText("Favourite"))
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.fragmentView.id, fragment)
            .commit()
    }
}