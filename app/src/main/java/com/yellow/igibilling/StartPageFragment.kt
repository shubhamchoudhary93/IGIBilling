package com.yellow.igibilling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.yellow.igibilling.databinding.StartPageBinding

class StartPageFragment : Fragment() {
private lateinit var binding : StartPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.start_page, container, false
        )

        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.addBill.setOnClickListener {
            view?.findNavController()
                ?.navigate(StartPageFragmentDirections.actionStartPageFragmentToNewBillPageFragment())
        }
    }
}