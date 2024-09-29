package com.mjink.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

// 아래 어노테이션 : 이 클래스를 상속 받는 클래스가 여기 안에 있는 필드들을 해당 엔티티에 있는 테이블의 컬럼과 매핑 가능
@MappedSuperclass
abstract class BaseEntity {
    @CreatedDate // JPA Entity가 생성된 시간 자동으로 세팅
    @Column(nullable = false, updatable = false) // 값이 null일 수 없고 이 필드의 처음 생성된 값이 변경된다면 오류 발생됨
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate // 마지막으로 수정된 일시는 언제인지
    @Column(nullable = false) // updatable은 기본값이 true
    var updatedDateTime: LocalDateTime = LocalDateTime.now()
}