package com.mjink.portfolio.domain.entity

import com.mjink.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
    name: String,
    type: String,
    isActive: Boolean
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill")
    var id: Long? = null

    var name: String = name

    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING) // 자료형이 enum클래스일때 사용하는 어노테이션 EnumType.STRING : 이름을 그대로 넣어줌
    var type: SkillType = SkillType.valueOf(type)
    // type의 문자열을 비교하여 SkillType에 있는 속성과 일치하는 것 반환

    var isActive: Boolean = isActive
}