package com.ardroid.rentalio.ui.pages.date

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ardroid.rentalio.R
import com.ardroid.rentalio.databinding.FragmentDateBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateFragment : Fragment() {

    private lateinit var dateViewModel: DateViewModel
    private var _binding: FragmentDateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dateViewModel =
            ViewModelProvider(this)[DateViewModel::class.java]

        _binding = FragmentDateBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.dateClose.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.dateClear.setOnClickListener {
            activity?.onBackPressed()
            findNavController().navigate(
                R.id.navigation_date
            )
        }

        binding.calendar.setOnDateClickListener { year, month, day ->
            val current = LocalDate.of(year, month+1, day)
            val formatter = DateTimeFormatter.ofPattern("E\nMMM dd")
            val formatted = current.format(formatter)
            binding.datePickUp.text = formatted
            binding.dateReturn.text = formatted
            binding.btnSave.isEnabled = true
            binding.btnSave.setBackgroundColor(resources.getColor(R.color.rentalio_orange))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}