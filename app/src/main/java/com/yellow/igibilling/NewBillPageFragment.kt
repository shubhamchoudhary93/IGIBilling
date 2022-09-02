package com.yellow.igibilling

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yellow.igibilling.database.SaleItem
import com.yellow.igibilling.databinding.NewBillPageBinding

class NewBillPageFragment : Fragment() {
    private lateinit var binding: NewBillPageBinding
    private var saleItemList: MutableList<SaleItem> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.new_bill_page, container, false
        )

        setDefaultValues()
        setListeners()
        return binding.root
    }

    private fun setDefaultValues() {
        val b = 0
    }

    private fun setListeners() {
        binding.addItemLayout.rateInputText.addTextChangedListener(textWatcher)
        binding.addItemLayout.percentageInputText.addTextChangedListener(textWatcher)

        binding.addItemLayout.addSaleButton.setOnClickListener {
            val itemName = binding.addItemLayout.itemNameInputText.text.toString()
            val itemRate = binding.addItemLayout.rateInputText.text.toString().toFloatOrNull()
            val itemQuantity =
                binding.addItemLayout.quantityInputText.text.toString().toFloatOrNull()
            val itemPercentage =
                binding.addItemLayout.percentageInputText.text.toString().toFloatOrNull()
            val itemCalculatedRate =
                binding.addItemLayout.calculatedRateInputText.text.toString().toFloatOrNull()
            val itemCalculatedTotal =
                binding.addItemLayout.calculatedTotalInputText.text.toString().toIntOrNull()

            val saleItem = SaleItem(
                0,
                0,
                itemName,
                itemQuantity ?: 0F,
                itemRate ?: 0F,
                itemPercentage ?: 0F,
                itemCalculatedRate ?: 0F,
                itemCalculatedTotal ?: 0
            )

            saleItemList.add(saleItem)
            binding.output.text = saleItemList.toString()
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            val itemRate = binding.addItemLayout.rateInputText.text.toString().toFloatOrNull()
            val itemPercentage =
                binding.addItemLayout.percentageInputText.text.toString().toFloatOrNull()
            var calculatedRate = itemRate
            if (itemPercentage != null) {
                if (itemRate != null) {
                    calculatedRate = itemRate * (1 + (itemPercentage / 100))
                }
            }
            binding.addItemLayout.calculatedRateInputText.setText(calculatedRate.toString())
            val itemQuantity =
                binding.addItemLayout.quantityInputText.text.toString().toFloatOrNull() ?: 0F
            val calculatedTotal = calculatedRate?.times(itemQuantity)
            binding.addItemLayout.calculatedTotalInputText.setText(calculatedTotal.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    }


}