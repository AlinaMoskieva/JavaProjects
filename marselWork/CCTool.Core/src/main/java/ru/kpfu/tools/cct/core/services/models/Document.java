package ru.kpfu.tools.cct.core.services.models;

import com.google.common.base.Objects;

import java.net.URL;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public class Document {
     private int id;
     private int taskId;
     private String fileName;
     private String type;
     private String folderName;
     private int size;
     private URL url;

    public Document(int id, int taskId, String fileName, String type, String folderName, int size, URL url) {
        this.id = id;
        this.taskId = taskId;
        this.fileName = fileName;
        this.type = type;
        this.folderName = folderName;
        this.size = size;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Document that = (Document)object;

        return Objects.equal(this.id, that.id) &&
                Objects.equal(this.taskId, that.taskId) &&
                Objects.equal(this.fileName, that.fileName) &&
                Objects.equal(this.type, that.type) &&
                Objects.equal(this.folderName, that.folderName) &&
                Objects.equal(this.size, that.size) &&
                Objects.equal(this.url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, taskId, fileName, type, folderName, size, url);
    }

}
