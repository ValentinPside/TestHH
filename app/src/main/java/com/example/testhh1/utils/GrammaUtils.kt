package com.example.testhh1.utils

object GrammaUtils {
    fun getSymbolFromCount(count: Int): String {
        var lastNumber = count
        if (count > 9) {
            lastNumber = count % 10
        }
        return when (lastNumber) {
            2 -> {
                "человека"
            }

            3 -> {
                "человека"
            }

            4 -> {
                "человека"
            }

            else -> {
                "человек"
            }
        }
    }

    fun getStringCount(count: Int): String{
        return when(count){
            1 -> {
                "$count вакансия"
            }

            2 -> {
                "$count вакансии"
            }

            3 -> {
                "$count вакансии"
            }

            4 -> {
                "$count вакансии"
            }

            else -> {
                "$count вакансий"
            }
        }
    }

    fun getStringDate(date: String): String {
        val monthOne = date.drop(5)
        val month = monthOne.dropLast(3)
        var day = date.drop(8)
        return when (month) {
            "01" -> {
                "Опубликовано $day января"
            }

            "02" -> {
                "Опубликовано $day февраля"
            }

            "03" -> {
                "Опубликовано $day марта"
            }

            "04" -> {
                "Опубликовано $day апреля"
            }

            "05" -> {
                "Опубликовано $day мая"
            }

            "06" -> {
                "Опубликовано $day июня"
            }

            "07" -> {
                "Опубликовано $day июля"
            }

            "08" -> {
                "Опубликовано $day августа"
            }

            "09" -> {
                "Опубликовано $day сенября"
            }

            "10" -> {
                "Опубликовано $day октября"
            }

            "11" -> {
                "Опубликовано $day ноября"
            }

            else -> {
                "Опубликовано $day декабря"
            }
        }
    }
}