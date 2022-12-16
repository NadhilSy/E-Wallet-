package org.nadhil.project.springboot.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SuccessResponse<T> extends CommonResponse{

    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SuccessResponse(String code, String message, T data){
        super.setCode(code);
        super.setMessage(message);
        super.setStatus(HttpStatus.OK.name());
        this.data = data;
    }
}
