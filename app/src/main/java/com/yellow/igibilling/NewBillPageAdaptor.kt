package com.yellow.igibilling

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yellow.igibilling.database.SaleItem
import com.yellow.igibilling.databinding.NewBillPageItemBinding

class NewBillPageAdaptor(val clickListener: NewBillPageListener) :
    ListAdapter<SaleItem, NewBillPageAdaptor.ViewHolder>(NewBillPageTransactionDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: NewBillPageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: SaleItem,
            clickListener: NewBillPageListener
        ) {
            binding.saleItem = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NewBillPageItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class NewBillPageTransactionDiffCallback : DiffUtil.ItemCallback<SaleItem>() {
        override fun areItemsTheSame(oldItem: SaleItem, newItem: SaleItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SaleItem, newItem: SaleItem): Boolean {
            return oldItem == newItem
        }
    }

    class NewBillPageListener(val clickListener: (id: Long) -> Unit) {
        fun onClick(saleItem: SaleItem) = clickListener(saleItem.id)
    }
}