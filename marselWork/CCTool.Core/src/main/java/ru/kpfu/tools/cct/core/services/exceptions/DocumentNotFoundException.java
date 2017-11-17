package ru.kpfu.tools.cct.core.services.exceptions;

/**
 * Created by Irinoise on 26.05.2015.
 */
public class DocumentNotFoundException extends RuntimeException {
    private String message;

    public DocumentNotFoundException(int documentId) {
        this.message = "Document with id <" + documentId + "> not found.";
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
