package com.ardroid.rentalio.ui.date

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ardroid.rentalio.databinding.FragmentDateBinding
import java.time.LocalDateTime
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
    ): View? {
        dateViewModel =
            ViewModelProvider(this).get(DateViewModel::class.java)

        _binding = FragmentDateBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.dateClose.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.calendar.setOnDateClickListener { year, month, day ->
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("E\nMMM dd")
            val formatted = current.format(formatter)
            binding.datePickUp.text = formatted
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}