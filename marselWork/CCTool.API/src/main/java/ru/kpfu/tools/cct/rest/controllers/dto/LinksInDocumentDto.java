package ru.kpfu.tools.cct.rest.controllers.dto;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;


/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@Dto
public class LinksInDocumentDto {

    private String self;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }
}
