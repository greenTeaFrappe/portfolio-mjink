package com.mjink.portfolio.presentation.service

import com.mjink.portfolio.presentation.dto.IntroductionDTO
import com.mjink.portfolio.presentation.dto.LinkDTO
import com.mjink.portfolio.presentation.dto.ProjectDTO
import com.mjink.portfolio.presentation.dto.ResumeDTO
import com.mjink.portfolio.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService(
    // 의존성 주입
    private val presentationRepository: PresentationRepository
) {
    // 메인 페이지를 호출하는 컨트롤러에서 호출
    @Transactional(readOnly = true) // 하나의 트랜젝션으로 묶임
    fun getIntroductions(): List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroductions()

        return introductions.map { IntroductionDTO(it) }
    }

    // 메인 페이지를 호출하는 컨트롤러에서 호출
    @Transactional(readOnly = true)
    fun getLinks(): List<LinkDTO> {
        val links = presentationRepository.getActiveLinks()

        return links.map { LinkDTO(it) }
    }

    // Resume 페이지를 호출하는 컨트롤러에서 호출
    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {
        val experiences = presentationRepository.getActiveExperiences()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkills()

        return ResumeDTO(
            experiences = experiences,
            achievements = achievements,
            skills = skills,
        )
    }

    // 프로젝트 페이지를 호출하는 컨트롤러에서 호출
    @Transactional(readOnly = true)
    fun getProjects(): List<ProjectDTO> {
        val projects = presentationRepository.getActiveProjects()

        return projects.map { ProjectDTO(it) }
    }
}