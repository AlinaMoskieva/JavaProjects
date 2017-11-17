package ru.kpfu.tools.cct.rest.controllers.dto.converters;

import ru.kpfu.tools.cct.core.services.models.Document;
import ru.kpfu.tools.cct.rest.controllers.dto.*;
import ru.kpfu.tools.cct.core.services.models.Task;

import java.util.List;
import java.util.Map;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public interface DtoAndEntityConverter {
    TaskDto fromTask(Task entity);
    TasksDto fromTasks(List<Task> entities);
    DocumentDto fromDocument(Document entity);
    DocumentsDto fromDocuments(List<Document> entities);
    Map<String, Integer> getIdsAsIntegerMap(TaskAssignmentDto dto);
    Map<String, Integer> getIdsAsIntegerMap(ComplaintDto dto);
}
