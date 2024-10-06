package com.example.testhh1.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testhh1.R
import com.example.testhh1.databinding.VacancyItemBinding
import com.example.testhh1.domain.models.Vacancy
import com.example.testhh1.utils.Constants
import com.example.testhh1.utils.GrammaUtils

class VacanciesAdapter : ListAdapter<Vacancy, VacanciesAdapter.ViewHolder>(DiffUtilVacancy()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = VacancyItemBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(vacancy: Vacancy) {
            if(vacancy.isFavorite){
                Glide.with(binding.favoriteIcon)
                    .load(Constants.favoriteIcon)
                    .into(binding.favoriteIcon)
            }
            binding.watchersTV.text = "Сейчас просматривает ${vacancy.lookingNumber} ${
                GrammaUtils.getSymbolFromCount(vacancy.lookingNumber)
            }"
            binding.profTV.text = vacancy.title
            binding.salaryTV.text = vacancy.salary.full
            binding.cityTV.text = vacancy.address.town
            binding.companyTV.text = vacancy.company
            binding.expTV.text = vacancy.experience.previewText
            binding.publishDateTV.text = GrammaUtils.getStringDate(vacancy.publishedDate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vacancy_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vacancy = currentList[position]
        holder.bind(vacancy)
    }

    private class DiffUtilVacancy : DiffUtil.ItemCallback<Vacancy>() {

        override fun areItemsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
            return oldItem == newItem
        }
    }
}