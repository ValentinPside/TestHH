package com.example.testhh1.domain

interface Repository {
    suspend fun makeRequest(): Response
}