package com.example.testhh1.utils

import com.example.testhh1.data.network.dto.AdressDto
import com.example.testhh1.data.network.dto.ButonDto
import com.example.testhh1.data.network.dto.ExperienceDto
import com.example.testhh1.data.network.dto.OfferDto
import com.example.testhh1.data.network.dto.ResponseDto
import com.example.testhh1.data.network.dto.SalaryDto
import com.example.testhh1.data.network.dto.VacancyDto
import com.example.testhh1.domain.models.Adress
import com.example.testhh1.domain.models.Buton
import com.example.testhh1.domain.models.Experience
import com.example.testhh1.domain.models.Offer
import com.example.testhh1.domain.models.Response
import com.example.testhh1.domain.models.Salary
import com.example.testhh1.domain.models.Vacancy

fun ResponseDto.asResponse() = Response(
    offers = this.offers.asOffers(),
    vacancies = this.vacancies.asVacancies()
    )

fun VacancyDto.asVacancy() = Vacancy(
    id = this.id,
    lookingNumber = this.lookingNumber,
    title = this.title,
    address = this.address.asAdress(),
    company = this.company,
    experience = this.experience.asExperience(),
    publishedDate = this.publishedDate,
    isFavorite = this.isFavorite,
    salary = this.salary.asSalary(),
    schedules = this.schedules,
    appliedNumber = this.appliedNumber,
    responsibilities = this.responsibilities,
    questions = this.questions

)

fun List<OfferDto>.asOffers() = this.map { it.asOffer() }

fun List<VacancyDto>.asVacancies() = this.map { it.asVacancy() }

fun OfferDto.asOffer() = Offer(
    id = this.id,
    title = this.title,
    button = this.button?.asButon(),
    link = this.link
)

fun SalaryDto.asSalary() = Salary(
    short = this.short,
    full = this.full
)

fun ExperienceDto.asExperience() = Experience(
    previewText = this.previewText,
    text = this.text
)

fun ButonDto.asButon() = Buton(
    text = this.text
)

fun AdressDto.asAdress() = Adress(
    town = this.town,
    street = this.street,
    house = this.house
)