package com.example.requests.models

import java.time.ZoneId
import java.util.UUID

class Bus (
    val id: String,
    val name: String,
    val ipAddress: String,
    val port: Int,
    val inUse: Boolean,
    val monitoring: Int,
    val maxUnavailable: Int,
    val timezone: String
)