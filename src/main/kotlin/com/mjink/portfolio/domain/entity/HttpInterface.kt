package com.mjink.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null

    var cookies: String? = httpServletRequest.cookies
        ?.map { "${it.name}:${it.value}" }
        ?.toString()

    var referer: String? = httpServletRequest.getHeader("referer")
    // referer : 구글 접속했다면 google.com의 도메인이 referer가 됨

    // 클라이언트와 관련된 ip 주소 같은것
    var localAddr: String? = httpServletRequest.localAddr

    var remoteAddr: String? = httpServletRequest.remoteAddr

    var remoteHost: String? = httpServletRequest.remoteHost

    // 어떤 URI로 접속했는지=
    var requestUri: String? = httpServletRequest.requestURI

    // 브라우저 정보 사파라인지 구글인지 모바일인지
    var userAgent: String? = httpServletRequest.getHeader("user-agent")
}