package com.example.testhh1.domain.models

data class Vacancy(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: Adress,
    val company: String,
    val experience: Experience,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: Salary,
    val schedules: List<String>,
    val appliedNumber: Int,
    val responsibilities: String,
    val questions: List<String>
)
