package ir.maktab.homeserviceprovider.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public abstract class AbstractRestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    protected String writeJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    protected <T> T readJson(String json, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }

}