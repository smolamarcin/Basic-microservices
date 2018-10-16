package com.smola.socialmultiplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smola.socialmultiplication.domain.Multiplication;
import com.smola.socialmultiplication.domain.MultiplicationResultAttempt;
import com.smola.socialmultiplication.domain.User;
import com.smola.socialmultiplication.service.MultiplicationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationResultAttemptController.class)
public class MultiplicationResultAttemptControllerTest {
    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mockMvc;

    private JacksonTester<MultiplicationResultAttempt> jsonResult;
    private JacksonTester<MultiplicationResultAttemptController.ResultResponse> jsonResponse;

    @Before
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void postResultReturnCorrect() throws Exception {
        genericParametrizedTest(true);
    }

    @Test
    public void postResultReturnNotCorrect() throws Exception {
        genericParametrizedTest(false);
    }

    private void genericParametrizedTest(boolean b) throws Exception {
        //given
        given(multiplicationService.checkAttempt(any(MultiplicationResultAttempt.class))).willReturn(b);
        User user = new User("john");
        Multiplication multiplication = new Multiplication(50, 70);
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3500);

        //when
        MockHttpServletResponse response = mockMvc.perform(post("/results")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonResult.write(attempt).getJson()))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString())
                .isEqualTo(jsonResponse.write(new MultiplicationResultAttemptController.ResultResponse(b)).getJson());
    }
}