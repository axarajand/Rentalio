package com.ardroid.rentalio.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ardroid.rentalio.*
import com.ardroid.rentalio.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    lateinit var vehicleAdapter: VehicleAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        vehicleAdapter = VehicleAdapter()

        vehicleAdapter.setVehicle(vehicleList)
        vehicleAdapter.onItemClick = { selected ->
            findNavController().navigate(
                R.id.navigation_vehicle_book
            )
        }

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.bannerViewPager.adapter = BannerAdapter(bannerList)
        binding.bannerViewPager.offscreenPageLimit = 1

        binding.rvVehicles.setHasFixedSize(true)

        showRvVehicles()

        return root
    }

    private fun showRvVehicles() {
        binding.rvVehicles.layoutManager = GridLayoutManager(activity, 4)
        binding.rvVehicles.adapter = vehicleAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}