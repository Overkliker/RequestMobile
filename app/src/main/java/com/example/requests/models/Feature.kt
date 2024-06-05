package com.example.requests.models

import java.util.UUID

data class Feature(
    val counterId: UUID,
    val constant: Int,
    val hasProfile: Boolean,
    val correctTime: Boolean,
)