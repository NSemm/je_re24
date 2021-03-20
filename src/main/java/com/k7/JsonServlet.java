package com.k7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class JsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    protected void writeJson(Object objList, HttpServletResponse response) throws JsonProcessingException {
        try {
            response.setHeader("Content-Type", "Application/json");
            String str = objectMapper.writeValueAsString(objList);
            response.getWriter().print(str);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected <T> T readJson(Class<T> clazz, HttpServletRequest request) throws IOException {
        return objectMapper.readValue(request.getInputStream(), clazz);
    }
}
