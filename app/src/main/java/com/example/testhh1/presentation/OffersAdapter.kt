package com.example.testhh1.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testhh1.R
import com.example.testhh1.databinding.OffersItemBinding
import com.example.testhh1.domain.models.Offer
import com.example.testhh1.utils.Constants.drawableList

class OffersAdapter(private val onClick: (url: String) -> Unit) :
    ListAdapter<Offer, OffersAdapter.ViewHolder>(DiffUtilOffer()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = OffersItemBinding.bind(itemView)

        fun bind(offer: Offer, drawable: Int) {
            binding.textView.text = offer.title.trimStart()
            binding.textView2.text = offer.button?.text ?: ""
            Glide.with(binding.iconImage)
                .load(drawable)
                .into(binding.iconImage)
            binding.root.setOnClickListener {
                onClick.invoke(offer.link)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.offers_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val offer = currentList[position]
        val drawable = drawableList[position]
        holder.bind(offer, drawable)
    }

    private class DiffUtilOffer : DiffUtil.ItemCallback<Offer>() {

        override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem == newItem
        }
    }
}