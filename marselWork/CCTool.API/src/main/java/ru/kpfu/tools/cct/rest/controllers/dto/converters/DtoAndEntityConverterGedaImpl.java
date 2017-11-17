package ru.kpfu.tools.cct.rest.controllers.dto.converters;

import com.google.common.collect.ImmutableMap;
import com.inspiresoftware.lib.dto.geda.adapter.BeanFactory;
import com.inspiresoftware.lib.dto.geda.adapter.ValueConverter;
import com.inspiresoftware.lib.dto.geda.assembler.Assembler;
import com.inspiresoftware.lib.dto.geda.assembler.DTOAssembler;
import org.springframework.stereotype.Component;
import ru.kpfu.tools.cct.core.services.models.Document;
import ru.kpfu.tools.cct.rest.controllers.dto.*;
import ru.kpfu.tools.cct.core.services.models.Task;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@Component
public class DtoAndEntityConverterGedaImpl implements DtoAndEntityConverter {

    private final String INT_TO_STR_ADAPTER_NAME = "IntegerToString";
    private final String URL_TO_STR_TASKS_ADAPTER_NAME = "UrlToLinksInTasks";
    private final String URL_TO_STR_DOCUMENTS_ADAPTER_NAME = "UrlToLinksInDocuments";

    private final ValueConverter integerToStringConverter = new ValueConverter() {
        @Override
        public Object convertToDto(Object o, BeanFactory beanFactory) {
            return String.valueOf(o);
        }

        @Override
        public Object convertToEntity(Object o, Object o1, BeanFactory beanFactory) {
            return Integer.parseInt(o.toString());
        }
    };

    private final ValueConverter urlToLinksInTasksConverter = new ValueConverter() {
        @Override
        public Object convertToDto(Object o, BeanFactory beanFactory) {
            URL url = (URL)o;
            LinksInTaskDto linksInTaskDto = new LinksInTaskDto();
            linksInTaskDto.setInstructionsFile(url.toString());
            return linksInTaskDto;
        }

        @Override
        public Object convertToEntity(Object o, Object o1, BeanFactory beanFactory) {
            // TODO
            return null;
        }
    };

    private final ValueConverter urlToLinksInDocumentsConverter = new ValueConverter() {
        @Override
        public Object convertToDto(Object object, BeanFactory beanFactory) {
            URL url = (URL)object;
            LinksInDocumentDto linksInDocumentDto = new LinksInDocumentDto();
            linksInDocumentDto.setSelf(url.toString());
            return linksInDocumentDto;
        }

        @Override
        public Object convertToEntity(Object object, Object oldEntity, BeanFactory beanFactory) {
            //TODO
            return null;
        }
    };

    private final Assembler taskAssembler = DTOAssembler.newAssembler(TaskDto.class, Task.class);
    private final Assembler documentAssembler = DTOAssembler.newAssembler(DocumentDto.class, Document.class);

    @Override
    public TaskDto fromTask(Task entity) {
        TaskDto taskDto = new TaskDto();
        Map<String, Object> adapters = new HashMap<String, Object>();
        adapters.put(INT_TO_STR_ADAPTER_NAME, integerToStringConverter);
        adapters.put(URL_TO_STR_TASKS_ADAPTER_NAME, urlToLinksInTasksConverter);

        taskAssembler.assembleDto(taskDto, entity, adapters, null);

        return taskDto;
    }

    private void taskDtosPrepare(List<TaskDto> taskDtos) {
        for (TaskDto taskDto : taskDtos) {
            taskDto.setAttributeDomainId(null);
            taskDto.setAuthorId(null);
            taskDto.setLinks(null);
        }
    }

    private void documentDtosPrepare(List<DocumentDto> documentDtos) {
        for (DocumentDto documentDto : documentDtos) {
            documentDto.setLinks(null);
        }
    }


    @Override
    public TasksDto fromTasks(List<Task> entities) {
        List<TaskDto> dtos = new LinkedList<TaskDto>();
        for (Task task : entities) {
            dtos.add(fromTask(task));
        }

        taskDtosPrepare(dtos);
        TasksDto result = new TasksDto();
        result.setTasks(dtos);
        return result;
    }

    @Override
    public DocumentDto fromDocument(Document entity) {
        DocumentDto documentDto = new DocumentDto();
        Map<String, Object> adapters = new HashMap<String, Object>();
        adapters.put(INT_TO_STR_ADAPTER_NAME, integerToStringConverter);
        adapters.put(URL_TO_STR_DOCUMENTS_ADAPTER_NAME, urlToLinksInDocumentsConverter);

        documentAssembler.assembleDto(documentDto, entity, adapters, null);

        return documentDto;
    }

    @Override
    public DocumentsDto fromDocuments(List<Document> entities) {
        List<DocumentDto> documentDtos = new LinkedList<DocumentDto>();
        for (Document document : entities) {
            documentDtos.add(fromDocument(document));
        }

        documentDtosPrepare(documentDtos);
        DocumentsDto result = new DocumentsDto();
        result.setDocuments(documentDtos);

        return result;
    }

    @Override
    public Map<String, Integer> getIdsAsIntegerMap(TaskAssignmentDto dto) {
        int userId = Integer.parseInt(dto.getUserId());
        int taskId = Integer.parseInt(dto.getTaskId());
        return ImmutableMap.of("userId", userId, "taskId", taskId);
    }

    @Override
    public Map<String, Integer> getIdsAsIntegerMap(ComplaintDto dto) {
        int userId = Integer.parseInt(dto.getUserId());
        int taskId = Integer.parseInt(dto.getTaskId());
        return ImmutableMap.of("userId", userId, "taskId", taskId);
    }
}
