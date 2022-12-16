package org.nadhil.project.springboot.response;

import lombok.Data;

@Data
public class ErrorResponse extends CommonResponse{

    public ErrorResponse(String code, String message) {
        super.setCode(code);
        super.setMessage(message);
        super.setStatus("ERROR");
    }

}
