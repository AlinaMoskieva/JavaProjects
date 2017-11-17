package ru.kpfu.tools.cct.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.kpfu.tools.cct.rest.controllers.dto.DataTransferObject;
import ru.kpfu.tools.cct.rest.controllers.dto.ResponseObjectDto;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public class ResponseBuilder {

    public static ResponseEntity<ResponseObjectDto> buildResponsePut(DataTransferObject data) {
        ResponseObjectDto body = new ResponseObjectDto("201", "success", data);
        ResponseEntity<ResponseObjectDto> response = new ResponseEntity<ResponseObjectDto>(body, HttpStatus.CREATED);
        return response;
    }

    public static ResponseEntity<ResponseObjectDto> buildResponseGet(DataTransferObject data) {
        ResponseObjectDto body = new ResponseObjectDto("200", "success", data);
        ResponseEntity<ResponseObjectDto> response = new ResponseEntity<ResponseObjectDto>(body, HttpStatus.OK);
        return response;
    }

}
