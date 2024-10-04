package com.mjink.portfolio.domain.repository

import com.mjink.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {
    // 시작점으로 넣어준 시간과 종료점으로 넣어준 시간 사이의 모든 데이터를 세서 넣어줌
    // ex. 오늘 방문자를 알아낼 수 있음
    fun countAllByCreatedDateTimeBetween(start: LocalDateTime, end: LocalDateTime): Long
}