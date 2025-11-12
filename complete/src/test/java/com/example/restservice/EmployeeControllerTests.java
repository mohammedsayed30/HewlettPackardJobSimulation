package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;


    //get all the employees
    @Test
    public void getAllEmployees() throws Exception {
        this.mockMvc.perform(get("/employees").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Employees").isArray())
                .andExpect(jsonPath("$.Employees.length()").value(3))
                .andExpect(jsonPath("$.Employees[0].firstName").value("Mohamed"))
                .andExpect(jsonPath("$.Employees[0].employeeId").value(100));
    }

    @Test
    @DirtiesContext
    public void addEmployee() throws Exception {
        String employeeJson = """
        {
          "employeeId": "103",
          "firstName": "Omar",
          "lastName": "Hassan",
          "email": "o.hassan@example.com",
          "title": "Junior Developer"
        }
    """;

        this.mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeId").value("103"))
                .andExpect(jsonPath("$.firstName").value("Omar"))
                .andExpect(jsonPath("$.lastName").value("Hassan"))
                .andExpect(jsonPath("$.email").value("o.hassan@example.com"))
                .andExpect(jsonPath("$.title").value("Junior Developer"));

    }
}
