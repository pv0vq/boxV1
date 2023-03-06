package com.jadoobox.boxV1.web.board;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class) // 스프링 부트와 jUnit 사이에 연결자
@WebMvcTest(controllers = BoardController.class) // web에 집중가능한 어노테이션, 사용가능한 어노테이션 => @Controller, @ControllerAdvice 사용가능, 사용불가능한 어노테이션 => @Service, @Repository
public class BoardControllerTest {

    @Autowired // 빈 주입
    private MockMvc mvc; //테스트의 시작점

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void findBoardList () throws Exception {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("content", "test");

        mvc.perform(get("/hello"))
                // .content(objectMapper.writeValueAsString(result)) //Map으로 만든 input을 json형식의 String으로 만들기 위해 objectMapper를 사용
                .andExpect(status().isOk()) // http status 검증을 한다 ok일 경우 200임
                .andDo(print());
                // .andExpect(content().string());
    }
}
