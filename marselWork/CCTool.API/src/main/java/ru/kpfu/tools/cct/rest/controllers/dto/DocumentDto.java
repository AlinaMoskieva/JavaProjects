package ru.kpfu.tools.cct.rest.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Dto
public class DocumentDto implements DataTransferObject {

    @DtoField(converter = "IntegerToString")
    private String id;

    @DtoField(converter = "IntegerToString")
    private String taskId;

    @DtoField
    private String fileName;

    @DtoField
    private String type;

    @DtoField
    private String folderName;

    @DtoField(converter = "IntegerToString")
    private String size;

    @DtoField (value = "url", converter = "UrlToLinksInDocuments", readOnly = true)
    private LinksInDocumentDto links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public LinksInDocumentDto getLinks() {
        return links;
    }

    public void setLinks(LinksInDocumentDto links) {
        this.links = links;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
