package com.mjink.portfolio.presentation.dto

import com.mjink.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String,
) {
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}