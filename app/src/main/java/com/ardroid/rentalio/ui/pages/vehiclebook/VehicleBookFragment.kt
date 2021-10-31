package com.ardroid.rentalio.ui.pages.vehiclebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ardroid.rentalio.R
import com.ardroid.rentalio.databinding.FragmentVehicleBookBinding

class VehicleBookFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentVehicleBookBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentVehicleBookBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.toolbar.toolbarBack.visibility = View.VISIBLE
        binding.toolbar.toolbarBack.setOnClickListener(this)

        binding.carChoose.withDriver.setOnClickListener(this)
        binding.carChoose.withoutDriver.setOnClickListener(this)
        binding.carChoose.transmissionAt.setOnClickListener(this)
        binding.carChoose.transmissionMt.setOnClickListener(this)
        binding.carChoose.fromDate.setOnClickListener(this)
        binding.carChoose.toDate.setOnClickListener(this)
        binding.checkAgree.setOnClickListener {
            if (binding.checkAgree.isChecked) {
                binding.btnBook.isEnabled = true
                binding.btnBook.setBackgroundColor(resources.getColor(R.color.rentalio_orange))
            } else {
                binding.btnBook.isEnabled = false
                binding.btnBook.setBackgroundColor(resources.getColor(R.color.rentalio_grey_light))
            }
        }

        return root
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.toolbar_back -> {
                activity?.onBackPressed()
            }
            R.id.with_driver -> {
                binding.carChoose.withDriver.setBackgroundColor(resources.getColor(R.color.rentalio_orange))
                binding.carChoose.withDriver.setTextColor(resources.getColor(R.color.rentalio_white))
                binding.carChoose.withoutDriver.setBackgroundColor(resources.getColor(R.color.rentalio_white))
                binding.carChoose.withoutDriver.setTextColor(resources.getColor(R.color.rentalio_black))
                binding.carChoose.tvTransmission.visibility = View.GONE
                binding.carChoose.transmissionChoose.visibility = View.GONE
            }
            R.id.without_driver -> {
                binding.carChoose.withoutDriver.setBackgroundColor(resources.getColor(R.color.rentalio_orange))
                binding.carChoose.withoutDriver.setTextColor(resources.getColor(R.color.rentalio_white))
                binding.carChoose.withDriver.setBackgroundColor(resources.getColor(R.color.rentalio_white))
                binding.carChoose.withDriver.setTextColor(resources.getColor(R.color.rentalio_black))
                binding.carChoose.tvTransmission.visibility = View.VISIBLE
                binding.carChoose.transmissionChoose.visibility = View.VISIBLE
            }
            R.id.transmission_at -> {
                binding.carChoose.transmissionAt.setBackgroundColor(resources.getColor(R.color.rentalio_orange))
                binding.carChoose.transmissionAtTv1.setTextColor(resources.getColor(R.color.rentalio_white))
                binding.carChoose.transmissionAtTv2.setTextColor(resources.getColor(R.color.rentalio_white))
                binding.carChoose.transmissionMt.setBackgroundColor(resources.getColor(R.color.rentalio_white))
                binding.carChoose.transmissionMtTv1.setTextColor(resources.getColor(R.color.rentalio_black))
                binding.carChoose.transmissionMtTv2.setTextColor(resources.getColor(R.color.rentalio_black))
            }
            R.id.transmission_mt -> {
                binding.carChoose.transmissionMt.setBackgroundColor(resources.getColor(R.color.rentalio_orange))
                binding.carChoose.transmissionMtTv1.setTextColor(resources.getColor(R.color.rentalio_white))
                binding.carChoose.transmissionMtTv2.setTextColor(resources.getColor(R.color.rentalio_white))
                binding.carChoose.transmissionAt.setBackgroundColor(resources.getColor(R.color.rentalio_white))
                binding.carChoose.transmissionAtTv1.setTextColor(resources.getColor(R.color.rentalio_black))
                binding.carChoose.transmissionAtTv2.setTextColor(resources.getColor(R.color.rentalio_black))
            }
            R.id.from_date -> {
                findNavController().navigate(
                    R.id.navigation_date
                )
            }
            R.id.to_date -> {
                findNavController().navigate(
                    R.id.navigation_date
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}