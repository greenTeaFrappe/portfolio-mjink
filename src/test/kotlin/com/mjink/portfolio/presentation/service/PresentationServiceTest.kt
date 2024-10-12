package com.mjink.portfolio.presentation.service

import com.mjink.portfolio.domain.entity.Introduction
import com.mjink.portfolio.domain.entity.Link
import com.mjink.portfolio.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {

    @InjectMocks // 실제로 테스트를 할 대상
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun testGetIntroductions() {
        // given 조건이 주어지고
        var introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE) {
            val introduction = Introduction(content = "${i}", isActive = i % 2 == 0)
            introductions.add(introduction)
        }


        val activeIntroductions = introductions.filter { introduction ->
            introduction.isActive
        } // == filter { it.isActive}

        Mockito.`when`(presentationRepository.getActiveIntroductions()).thenReturn(activeIntroductions)

        // when 동작을 했을 때
        // 내부적으로 데이터베이스에서 true인것만 조회해서 return
        // spring이 안떠있는 상황에서 가정한대로 데이터를 반환하도록
        val introductionDTOs = presentationService.getIntroductions()

        // then 결과가 어떻게 될 것인가
        assertThat(introductionDTOs).hasSize(DATA_SIZE / 2)
        for (introductionDTO in introductionDTOs) {
            // true = 짝수
            assertThat(introductionDTO.content.toInt()).isEven() // 짝수인지를 검증
            // 짝수가 아니면 getIntroductions에 오류가 있음을 알 수 있음
        }
    }

    @Test
    fun testGetLinks() {
        // given
        val links = mutableListOf<Link>()
        for (i in 1..DATA_SIZE) {
            val link = Link(name = "${i}", content = "${i}", isActive = i % 2 != 0)
            links.add(link)
        }

        val activeLinks = links.filter { link ->
            link.isActive
        }

        Mockito.`when`(presentationRepository.getActiveLinks())
            .thenReturn(activeLinks)

        // when
        val linkDTOs = presentationService.getLinks()

        // then
        var expectedSize = DATA_SIZE / 2
        if (DATA_SIZE % 2 != 0) {
            expectedSize += 1
        }
        assertThat(linkDTOs).hasSize(expectedSize)
        for (linkDTO in linkDTOs) {
            assertThat(linkDTO.content.toInt()).isOdd()
        }
    }
}