package com.jachai.walleto_expensemanager.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jachai.walleto_expensemanager.R
import com.jachai.walleto_expensemanager.data.model.Transaction
import com.jachai.walleto_expensemanager.databinding.ItemTransactionLayoutBinding
import indianRupee

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.TransactionVH>() {

    inner class TransactionVH(val binding: ItemTransactionLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Transaction>() {
        override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionVH {
        val binding =
            ItemTransactionLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionVH(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: TransactionVH, position: Int) {

        val item = differ.currentList[position]
        holder.binding.apply {

            transactionName.text = item.title
            transactionCategory.text = item.tag

            when (item.transactionType) {
                "Income" -> {
                    transactionAmount.setTextColor(
                        ContextCompat.getColor(
                            transactionAmount.context,
                            R.color.income
                        )
                    )

                    transactionAmount.text = "+ ".plus(indianRupee(item.amount))
                }
                "Expense" -> {
                    transactionAmount.setTextColor(
                        ContextCompat.getColor(
                            transactionAmount.context,
                            R.color.expense
                        )
                    )
                    transactionAmount.text = "- ".plus(indianRupee(item.amount))
                }
            }

            when (item.tag) {
                "Housing" -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
                "Transportation" -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
                "Food" -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
                "Utilities" -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
                "Insurance" -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
                "Healthcare" -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
                "Saving & Debts" -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
                "Personal Spending" -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
                "Entertainment" -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
                "Miscellaneous" -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
                else -> {
                    transactionIconView.setImageResource(R.drawable.ic_others)
                }
            }

            // on item click
            holder.itemView.setOnClickListener {
                onItemClickListener?.let { it(item) }
            }
        }
    }

    // on item click listener
    private var onItemClickListener: ((Transaction) -> Unit)? = null
    fun setOnItemClickListener(listener: (Transaction) -> Unit) {
        onItemClickListener = listener
    }
}
