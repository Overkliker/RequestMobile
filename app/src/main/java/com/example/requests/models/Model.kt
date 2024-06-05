package com.example.requests.models

import java.util.UUID

class Model (
    var id: UUID,
    var brand: Brand,
    var name: String,
    var title: String,
    var phase_count: Int,
    var description: String,
    var needPassword: Boolean,
    var addressMask: String,
    var pollData: Set<PollData>
)