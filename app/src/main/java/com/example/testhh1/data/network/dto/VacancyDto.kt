package com.example.testhh1.data.network.dto

data class VacancyDto(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: AdressDto,
    val company: String,
    val experience: ExperienceDto,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: SalaryDto,
    val schedules: List<String>,
    val appliedNumber: Int,
    val responsibilities: String,
    val questions: List<String>
)
