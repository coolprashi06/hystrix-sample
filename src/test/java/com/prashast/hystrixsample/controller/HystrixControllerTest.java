package com.prashast.hystrixsample.controller;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HystrixControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private HystrixController controller;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testController() throws Exception{
        mockMvc.perform(get("/hystrix/getContent/general"))
                .andExpect(status().isOk())
                .andExpect(content().string("General Content"));

        mockMvc.perform(get("/hystrix/getContent/fallback"))
                .andExpect(status().isOk())
                .andExpect(content().string("Fallback Content"));
    }

}
