//package com.jioo.delivery.controller;
//
//import java.io.IOException;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping(value="/oauth2/code/*")
//public class MemberController {
//
//    @RequestMapping(value="/kakao", method=RequestMethod.GET)
//    public String kakaoLogin(@RequestParam(value = "code", required = false) String code) throws Exception {
//        System.out.println("#########" + code);
//        return "oauth2/code/testPage";
//        /*
//         * 리턴값의 testPage는 아무 페이지로 대체해도 괜찮습니다.
//         * 없는 페이지를 넣어도 무방합니다.
//         * 404가 떠도 제일 중요한건 #########인증코드 가 잘 출력이 되는지가 중요하므로 너무 신경 안쓰셔도 됩니다.
//         */
//    }
//
//}