package ru.kpfu.tools.cct.rest.controllers.dto;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@Dto
public class LinksInTaskDto {

    private String instructionsFile;

    public String getInstructionsFile() {
        return instructionsFile;
    }

    public void setInstructionsFile(String instructionsFile) {
        this.instructionsFile = instructionsFile;
    }
}
