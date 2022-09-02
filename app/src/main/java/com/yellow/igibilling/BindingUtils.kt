package com.yellow.igibilling

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.yellow.igibilling.database.SaleItem


@BindingAdapter("itemNameString")
fun TextView.setItemNameString(item: SaleItem) {
    item.let {
        text = item.item
    }

}

@BindingAdapter("itemQuantityString")
fun TextView.setItemQuantityString(item: SaleItem) {
    item.let {
        text = item.quantity.toString()
    }
}

@BindingAdapter("itemTotalString")
fun TextView.setItemTotalString(item: SaleItem) {
    item.let {
        text = item.total.toString()
    }
}

@BindingAdapter("itemRateString")
fun TextView.setItemRateString(item: SaleItem) {
    item.let {
        text = item.calculatedRate.toString()
    }
}
