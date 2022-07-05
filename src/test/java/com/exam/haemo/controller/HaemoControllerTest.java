package com.exam.haemo.controller;
import static org.hamcrest.Matchers.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HaemoController.class)
@AutoConfigureRestDocs
class HaemoControllerTest {

    @Autowired
    private MockMvc mockMvc; // (2)

    @Test
    public void test_책을_조회하면_null이_아닌_객체를_리턴한다() throws Exception {
        mockMvc.perform(get("/book/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(document("book", // (3)
                        pathParameters(
                                parameterWithName("id").description("book unique id") // (4)
                        ),
                        responseFields(
                                fieldWithPath("id").description("book unique id"),
                                fieldWithPath("title").description("title"),
                                fieldWithPath("author").description("author")
                        )
                ))
                .andExpect(jsonPath("$.id", is(notNullValue()))) // (5)
                .andExpect(jsonPath("$.title", is(notNullValue())))
                .andExpect(jsonPath("$.author", is(notNullValue())));
    }

    @Test
    public void test_memberAll() throws Exception {
        mockMvc.perform(get("http://localhost:8080/memberTest")
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(document("member", // (3)
                        responseFields(
                                fieldWithPath("mber_no").description("회원번호"),
                                fieldWithPath("id").description("아이디"),
                                fieldWithPath("name").description("이름")
                        )
                ))
                .andExpect(jsonPath("$.mber_no", is(notNullValue()))) // (5)
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.name", is(notNullValue())));
    }
}