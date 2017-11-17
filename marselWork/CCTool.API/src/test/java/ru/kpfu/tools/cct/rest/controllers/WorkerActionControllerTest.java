package ru.kpfu.tools.cct.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.kpfu.tools.cct.core.services.WorkerServiceFacade;
import ru.kpfu.tools.cct.core.services.exceptions.TaskNotFoundException;
import ru.kpfu.tools.cct.rest.controllers.dto.TaskAssignmentDto;


import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kpfu.tools.cct.core.services.dao.TaskDaoData.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestWebAppContext.class, CctWebAppContext.class })
@WebAppConfiguration
public class WorkerActionControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WorkerServiceFacade workerServiceFacade;

    @Autowired
    WebApplicationContext webApplicationContext;

    final ObjectMapper objectMapper = new ObjectMapper();
    @Before
    public void setUp() throws Exception {
        Mockito.reset(workerServiceFacade);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Mockito.doThrow(TaskNotFoundException.class).when(workerServiceFacade).getTask(Matchers.anyInt());
        Mockito.doReturn(TASK_1).when(workerServiceFacade).getTask(TASK_1.getId());
        Mockito.doReturn(Lists.newArrayList(TASK_1, TASK_2)).when(workerServiceFacade).getAvailableTasks();
    }

    @Test
    public void testGetTask() throws Exception {
        mockMvc.perform(get("/tasks/{task-id}.json", TASK_1.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(String.valueOf(TASK_1.getId()))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authorId", Is.is(String.valueOf(TASK_1.getAuthorId()))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", is(TASK_1.getDescription())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.attributeDomainId", Is.is(String.valueOf(TASK_1.getAttributeDomainId()))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.links.instructionsFile", is(TASK_1.getInstructions().toString())));
    }

    @Test
    public void testGetTaskForIncorrectTaskId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tasks/{task-id}.json", 1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Is.is("404")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Is.is("error")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is("Id of task is invalid")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data", Is.is("TaskNotFoundException")));
    }

    @Test
    public void testGetTasks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tasks.json").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.tasks[0].id", Is.is(String.valueOf(TASK_1.getId()))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tasks[0].description", is(TASK_1.getDescription())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tasks[1].id", Is.is(String.valueOf(TASK_2.getId()))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tasks[1].description", is(TASK_2.getDescription())));

    }

    @Test
    public void testPostTaskAssignment() throws Exception {
        TaskAssignmentDto assignmentDto = new TaskAssignmentDto();
        assignmentDto.setTaskId("1");
        assignmentDto.setUserId("1");

        String json = objectMapper.writeValueAsString(assignmentDto);
        mockMvc.perform(post("/tasks/assignments").contentType(MediaType.APPLICATION_JSON)
                .content(json.getBytes()))
                .andExpect(status().isCreated());
        verify(workerServiceFacade).taskAssign(1, 1);
    }
}