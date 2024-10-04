package com.mjink.portfolio.domain.repository

import com.mjink.portfolio.domain.entity.Experience
import com.mjink.portfolio.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.Test

@DataJpaTest // JPA 관련 테스트를 실행할 때 사용하는 어노테이션 @Transcational 통해 테스트를 하나의 트랜잭션으로 취급
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 한 번 만든 메소드로 다른 메소드 전부 실행 가능 의존적인 성격
// 초기화 하는 메소드 : 한 번 돌아야함 따라서 Lifecycle을 Class로 해줌
// beforeAll : @DataJpaTest를 쓰면 테스트 할 기능들만 초기화 해줌 그래서 만들어둔 데이터들이 초기화 되지 않기 때문에 따로 초기화 해줌
class ExperienceRepositoryTest(
    @Autowired val experienceRepository: ExperienceRepository
) {
    val DATA_SIZE = 10

    private fun createExperience(n: Int): Experience {
        val experience = Experience(
            title = "${n}",
            description = "테스트 설명 ${n}",
            startYear = 2023,
            startMonth = 9,
            endYear = 2023,
            endMonth = 9,
            isActive = true
        )
        val details = mutableListOf<ExperienceDetail>()
        for (i in 1..n) { // 1부터 n까지 XX0부터XX
            val experienceDetail = ExperienceDetail(content = "테스트 ${i}", isActive = true)
            details.add(experienceDetail)
        }
        experience.addDetails(details)

        return experience
    }

    @BeforeAll
    fun beforeAll() {
        println("---- 데이터 초기화 이전 조회 시작 ----")
        val beforeInitialize = experienceRepository.findAll()
        assertThat(beforeInitialize).hasSize(0) // 사이즈가 0이면 테스트 통과
        println("---- 데이터 초기화 이전 조회 종료 ----")

        println("---- 테스트 데이터 초기화 시작 ----")
        val experiences = mutableListOf<Experience>()
        for (i in 1..DATA_SIZE) {
            val experience = createExperience(i)
            experiences.add(experience)
        }
        experienceRepository.saveAll(experiences)
        println("---- 테스트 데이터 초기화 종료 ----")
    }

    @Test
    fun testFindAll() {
        println("---- findAll 테스트 시작 ----")
        val experiences = experienceRepository.findAll()
        assertThat(experiences).hasSize(DATA_SIZE)
        println("Experiences.size: ${experiences.size}")

        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("Experience.size: ${experience.details.size}")
        }
        println("---- findAll 테스트 종료 ----")
    }

    @Test
    fun testFindAllByIsActive() {
        println("---- findAllByIsActive 테스트 시작 ----")
        val experiences = experienceRepository.findAllByIsActive(true)
        assertThat(experiences).hasSize(DATA_SIZE)
        println("Experiences.size: ${experiences.size}")

        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("Experience.size: ${experience.details.size}")
        }
        println("---- findAllByIsActive 테스트 종료 ----")
    }
}