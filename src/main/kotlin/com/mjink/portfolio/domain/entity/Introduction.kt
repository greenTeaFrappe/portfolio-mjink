package com.mjink.portfolio.domain.entity

import jakarta.persistence.*

@Entity // Entity 어노테이션을 달아줘야 JPA에서 테이블과 매핑되는 엔티티 클래스라는 것을 알 수 있음
class Introduction : BaseEntity() {
    @Id // 이 필드가 PK다 라는 것을 알 수 있음
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 전략을 정해줌
    // GenerationType.TABLE : PK를 만들기 위한 테이블을 전용으로 만들어 PK 생성
    // GenerationType.SEQUENCE : 순서대로 번호를 따지는 기능 MySQL은 사용 불가
    // GenerationType.IDENTITY : 기본키 생성을 DB에 위임
    // GenerationType.AUTO : JPA가 내부 알고리즘을 따라 자동으로 전략 결정
    @Column(name = "introduction_id") // 이 필드가 어떤 네임을 가진 컬럼이랑 매핑 되는지 개발자가 직접 지정
    // val achievement: Achievement
    // achievement.achievementID
    // achievement.id -> 이쪽이 더 직관적
    var id: Long? = null
}