package com.mjink.portfolio.domain.entity

import jakarta.persistence.*

@Entity // Entity 어노테이션을 달아줘야 JPA에서 테이블과 매핑되는 엔티티 클래스라는 것을 알 수 있음
class ProjectDetail : BaseEntity() {
    @Id // 이 필드가 PK다 라는 것을 알 수 있음
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 전략을 정해줌
    // GenerationType.TABLE : PK를 만들기 위한 테이블을 전용으로 만들어 PK 생성
    // GenerationType.SEQUENCE : 순서대로 번호를 따지는 기능 MySQL은 사용 불가
    // GenerationType.IDENTITY : 기본키 생성을 DB에 위임
    // GenerationType.AUTO : JPA가 내부 알고리즘을 따라 자동으로 전략 결정
    @Column(name = "project_detail_id")
    var id: Long? = null
}