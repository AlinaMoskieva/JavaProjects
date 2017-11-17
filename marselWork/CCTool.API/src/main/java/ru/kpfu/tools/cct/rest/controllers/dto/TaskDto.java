package ru.kpfu.tools.cct.rest.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Dto
public class TaskDto implements DataTransferObject {

    @DtoField (converter = "IntegerToString")
    private String id;

    @DtoField (converter = "IntegerToString")
    private String authorId;

    @DtoField
    private String description;

    @DtoField (converter = "IntegerToString")
    private String attributeDomainId;

    @DtoField (value = "instructions", converter = "UrlToLinksInTasks", readOnly = true)
    private LinksInTaskDto links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttributeDomainId() {
        return attributeDomainId;
    }

    public void setAttributeDomainId(String attributeDomainId) {
        this.attributeDomainId = attributeDomainId;
    }

    public LinksInTaskDto getLinks() {
        return links;
    }

    public void setLinks(LinksInTaskDto links) {
        this.links = links;
    }
}
