package com.mjink.portfolio.presentation.dto

import com.mjink.portfolio.domain.entity.Achievement
import com.mjink.portfolio.domain.entity.Experience
import com.mjink.portfolio.domain.entity.Skill
import java.time.format.DateTimeFormatter

// resumeDTO : experiences, achievements, skills를 각각 가져오는 것 보다는 하나의 통에 담아 가져오는 것이 더 낫기 때문에 생성
class ResumeDTO(
    experiences: List<Experience>,
    achievements: List<Achievement>,
    skills: List<Skill>
) {
    var experiences: List<ExperienceDTO> = experiences.map {
        ExperienceDTO(
            title = it.title,
            description = it.description,
            startYearMonth = "${it.startYear}.${it.startMonth}",
            endYearMonth = it.getEndYearMonth(),
            details = it.details.filter { it.isActive }.map { it.content }
        )
    }

    var achievements: List<AchievementDTO> = achievements.map {
        AchievementDTO(
            title = it.title,
            description = it.description,
            host = it.host,
            achievedDate = it.achivedDate
                ?.format(DateTimeFormatter.ISO_LOCAL_DATE)  // yyyy-mm-dd
                ?.replace("-", ".") // yyyy.mm.dd
        )
    }

    var skills: List<SkillDTO> = skills.map { SkillDTO(it) }
}