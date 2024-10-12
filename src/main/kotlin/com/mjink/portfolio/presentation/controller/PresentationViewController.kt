package com.mjink.portfolio.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller // html 파일을 리턴해주는 것이 전제
class PresentationViewController {

    @GetMapping("/test") // 컨트롤러에서 이 부분을 찾아 실행시켜줌
    fun test(): String {
        return "test"
    }
}