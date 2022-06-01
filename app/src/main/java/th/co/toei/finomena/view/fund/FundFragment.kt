package th.co.toei.finomena.view.fund

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import th.co.toei.finomena.R
import th.co.toei.finomena.databinding.FragmentFundBinding

@AndroidEntryPoint
class FundFragment : Fragment() {
    lateinit var binding: FragmentFundBinding

    private val vm: FundViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFundBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTabLayoutTop()
        init()
    }

    private fun init() {
        binding.tabLayoutTop.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                vm.getListFund(tab?.text.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun initTabLayoutTop() {
        binding.tabLayoutTop.addTab(binding.tabLayoutTop.newTab().setText("1D"))
        binding.tabLayoutTop.addTab(binding.tabLayoutTop.newTab().setText("1W"))
        binding.tabLayoutTop.addTab(binding.tabLayoutTop.newTab().setText("1M"))
        binding.tabLayoutTop.addTab(binding.tabLayoutTop.newTab().setText("1Y"))
    }

    companion object {
        fun newInstance(): Fragment = FundFragment()
    }
}