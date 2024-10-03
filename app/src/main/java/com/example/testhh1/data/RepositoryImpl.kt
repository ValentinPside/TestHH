package com.example.testhh1.data

import com.example.testhh1.data.network.NetworkServiceAPI
import com.example.testhh1.domain.Repository
import com.example.testhh1.domain.models.Response
import com.example.testhh1.utils.asResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: NetworkServiceAPI) : Repository {

    override suspend fun makeRequest(): Response{
        return withContext(Dispatchers.IO) {
            val responseDto = api.getResponse()
            responseDto.asResponse()
        }
    }

}