package ru.kpfu.tools.cct.rest.controllers.dto;


import java.util.List;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public class DocumentsDto implements DataTransferObject {
    private List<DocumentDto> documents;

    public List<DocumentDto> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentDto> documents) {
        this.documents = documents;
    }
}
