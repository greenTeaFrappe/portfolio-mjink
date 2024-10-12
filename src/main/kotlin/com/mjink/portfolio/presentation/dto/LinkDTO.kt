package com.mjink.portfolio.presentation.dto

import com.mjink.portfolio.domain.entity.Link

class LinkDTO(
    val name: String,
    val content: String,
) {
    constructor(link: Link) : this(
        name = link.name.lowercase(),
        content = link.content
    )
}