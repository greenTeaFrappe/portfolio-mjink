package com.mjink.portfolio.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api") // 클래스 위에 리퀘스트 매핑 해주면 하위에다가 이 경로를 다 붙여줌
class PresentationApiController {

    @GetMapping("/test") // ../api/test 이렇게 됨
    fun test(): String {
        return "OK" // 리턴한 객체를 그대로 바디에 넣어줌
    }
}