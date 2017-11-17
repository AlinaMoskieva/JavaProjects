package ru.kpfu.tools.cct.core.services.models;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.net.URL;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public class Task {
    private int id;
    private int authorId;
    private String description;
    private int attributeDomainId;
    private URL instructions;

    public Task(int id, int authorId, String description, int attributeDomainId, URL instructions) {
        this.id = id;
        this.authorId = authorId;
        this.description = description;
        this.attributeDomainId = attributeDomainId;
        this.instructions = instructions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttributeDomainId() {
        return attributeDomainId;
    }

    public void setAttributeDomainId(int attributeDomainId) {
        this.attributeDomainId = attributeDomainId;
    }

    public URL getInstructions() {
        return instructions;
    }

    public void setInstructions(URL instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Task that = (Task)object;

        return Objects.equal(this.id, that.id) &&
                Objects.equal(this.authorId, that.authorId) &&
                Objects.equal(this.description, that.description) &&
                Objects.equal(this.attributeDomainId, that.attributeDomainId) &&
                Objects.equal(this.instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, authorId, description, attributeDomainId, instructions);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("Id", this.id)
                .add("AuthorId", this.authorId)
                .add("Description", this.description).toString();
    }
}
