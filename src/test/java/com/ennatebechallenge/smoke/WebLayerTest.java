package com.ennatebechallenge.smoke;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void create() throws Exception {
        String json = "{\n" +
                "  \"timeStamp\": 1313045045, \n" +
                "  \"weight\": 130\n" +
                "}";
        mockMvc.perform(post("/metrics/create").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());    
    }

//    @RunWith(SpringRunner.class)
//    @WebMvcTest
//    public class WebLayerTest {
//
//        @Autowired
//        private MockMvc mockMvc;
//
//        @Test
//        public void shouldReturnDefaultMessage() throws Exception {
//            this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//                    .andExpect(content().string(containsString("Hello World")));
//        }
//    }

}