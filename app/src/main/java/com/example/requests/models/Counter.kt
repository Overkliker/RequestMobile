package com.example.requests.models

import java.math.BigDecimal
import java.time.OffsetDateTime
import java.time.ZoneId
import java.util.UUID

class Counter(
    val id: String,
    val busId: String,
    val modelId: String,
    val disable: Boolean,
    val inactive: Boolean,
    val number: String,
    val password: String,
    val tariffCount: Int,
    val transformRatio: Int,
    val interval: Int,
    val pollKinds: List<String>,
    val monitoring: Boolean,
    val installDate: String,
    val uninstallDate: String?,
    val serial: String,
    val timezone: String,
    val installIndication: BigDecimal,
    val feature: Feature
)