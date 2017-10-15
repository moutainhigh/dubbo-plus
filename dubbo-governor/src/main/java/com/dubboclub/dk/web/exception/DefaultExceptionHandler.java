package com.dubboclub.dk.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dubboclub.dk.web.model.BasicResponse;

@ControllerAdvice
public class DefaultExceptionHandler {

	@ResponseBody
    @ExceptionHandler(DataHadChangedException.class)
    public BasicResponse dataHadChanged(){
        BasicResponse response = new BasicResponse();
        response.setResult(BasicResponse.FAILED);
        response.setMemo("数据已经发生变更！");
        return response;
    }
    
}
