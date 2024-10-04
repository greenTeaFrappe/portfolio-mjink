package com.mjink.portfolio.domain.repository

import com.mjink.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long> {
    // JPA에서 알아서 쿼리 생성함 select * from achievement where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Achievement>
}