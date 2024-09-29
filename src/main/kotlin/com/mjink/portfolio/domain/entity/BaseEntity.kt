package com.mjink.portfolio.domain.entity

import jakarta.persistence.MappedSuperclass

// 아래 어노테이션 : 이 클래스를 상속 받는 클래스가 여기 안에 있는 필드들을 해당 엔티티에 있는 테이블의 컬럼과 매핑 가능
@MappedSuperclass
abstract class BaseEntity