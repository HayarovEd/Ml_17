package com.savingsmart.domain

import com.savingsmart.data.Resource
import com.savingsmart.domain.model.basedto.BaseDto

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDto>
}