package com.yellow.igibilling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yellow.igibilling.databinding.NewBillPageBinding
import com.yellow.igibilling.databinding.ShowBillPageBinding

class ShowBillPageFragment : Fragment() {
private lateinit var binding : ShowBillPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.show_bill_page, container, false
        )

        setDefaultValues()
        setListeners()
        return binding.root
    }

    private fun setDefaultValues() {
        TODO("Not yet implemented")
    }

    private fun setListeners() {
        TODO("Not yet implemented")
    }
}