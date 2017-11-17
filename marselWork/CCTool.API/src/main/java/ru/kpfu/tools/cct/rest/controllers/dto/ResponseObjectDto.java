package ru.kpfu.tools.cct.rest.controllers.dto;

public class ResponseObjectDto implements DataTransferObject {
    private String code;
    private String status;
    private DataTransferObject data;

    public ResponseObjectDto(String code, String status, DataTransferObject data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataTransferObject getData() {
        return data;
    }

    public void setData(DataTransferObject data) {
        this.data = data;
    }
}
