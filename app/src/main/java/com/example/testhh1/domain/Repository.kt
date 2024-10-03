package com.example.testhh1.domain

import com.example.testhh1.domain.models.Response

interface Repository {
    suspend fun makeRequest(): Response
}