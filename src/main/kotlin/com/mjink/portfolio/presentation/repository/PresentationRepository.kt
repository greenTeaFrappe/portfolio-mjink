package com.mjink.portfolio.presentation.repository

import com.mjink.portfolio.domain.entity.*
import com.mjink.portfolio.domain.repository.*
import org.springframework.stereotype.Repository

// PresentationRepository : 디자인 패턴 중 Facade Pattern 역할을 함
// domain의 repository -> 직접적으로 데이터베이스와 가장 단순한 상호작용을 하는 코어적인 기능
// PresentationRepository -> 도메인의 기능을 이용해서 프리젠테이션 레이어에 필요한 데이터베이스 조회, 저장 등을 한번 더 레핑해서 사용하는 기능
@Repository
class PresentationRepository(
    // 의존성 주입
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {
    fun getActiveAchievements(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }

    fun getActiveExperiences(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }

    fun getActiveIntroductions(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }

    fun getActiveLinks(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }

    fun getActiveSkills(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }

    fun getActiveProjects(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }
}