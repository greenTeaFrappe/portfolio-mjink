package com.mjink.portfolio.presentation.dto

data class AchievementDTO(
    val title: String,
    val description: String,
    val host: String,
    val achievedDate: String?, // 클라에서는 문자열 그대로 하는것이 편하기 때문에 서버가 전달하고자 하는 데이터를 원하는 포맷으로 바꿔서 전달
)