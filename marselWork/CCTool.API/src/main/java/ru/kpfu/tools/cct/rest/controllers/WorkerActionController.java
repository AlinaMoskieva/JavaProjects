package ru.kpfu.tools.cct.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.tools.cct.core.services.models.Document;
import ru.kpfu.tools.cct.core.services.models.Task;
import ru.kpfu.tools.cct.rest.controllers.dto.*;
import ru.kpfu.tools.cct.rest.controllers.dto.converters.DtoAndEntityConverter;
import ru.kpfu.tools.cct.core.services.WorkerServiceFacade;

import java.util.List;
import java.util.Map;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@RestController
public class WorkerActionController {

    @Autowired
    private WorkerServiceFacade workerServiceFacade;

    @Autowired
    private DtoAndEntityConverter converter;

    @RequestMapping(value = "/tasks.json",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseObjectDto> getTasks() {
        List<Task> tasks = workerServiceFacade.getAvailableTasks();
        TasksDto tasksDto = converter.fromTasks(tasks);
        return ResponseBuilder.buildResponseGet(tasksDto);
    }

    @RequestMapping(value = "/tasks/{task-id}.json",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseObjectDto> getTask(@PathVariable("task-id") int taskId) {
        Task task = workerServiceFacade.getTask(taskId);
        TaskDto taskDto = converter.fromTask(task);
        return ResponseBuilder.buildResponseGet(taskDto);
    }

    @RequestMapping(value = "/tasks/assignments",
            method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseObjectDto> taskAssign(@RequestBody TaskAssignmentDto taskAssignmentDto) {
        Map<String, Integer> dtoValues = converter.getIdsAsIntegerMap(taskAssignmentDto);
        workerServiceFacade.taskAssign(dtoValues.get("userId"), dtoValues.get("taskId"));
        return ResponseBuilder.buildResponsePut(taskAssignmentDto);
    }

    @RequestMapping(value = "/tasks/{task-id}/documents.json",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseObjectDto> getDocuments(@PathVariable("task-id") int taskId) {
        List<Document> documents = workerServiceFacade.getDocuments(taskId);
        DocumentsDto documentsDto = converter.fromDocuments(documents);
        return ResponseBuilder.buildResponseGet(documentsDto);
    }

    @RequestMapping(value = "tasks/{task-id}/documents/{document-id}.json",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseObjectDto> getDocument(@PathVariable("document-id") int documentId) {
        Document document = workerServiceFacade.getDocument(documentId);
        DocumentDto documentDto = converter.fromDocument(document);
        return ResponseBuilder.buildResponseGet(documentDto);
    }

    @RequestMapping(value = "tasks/complaints",
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseObjectDto> complaintToTask(@RequestBody ComplaintDto complaintDto) {
        Map<String, Integer> dtoValues = converter.getIdsAsIntegerMap(complaintDto);
        workerServiceFacade.complaintToTask(dtoValues.get("userId"), dtoValues.get("taskId"), complaintDto.getDescription());
        return ResponseBuilder.buildResponsePut(complaintDto);
    }


}
