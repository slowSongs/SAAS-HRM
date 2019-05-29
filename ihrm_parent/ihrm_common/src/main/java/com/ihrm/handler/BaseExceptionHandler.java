package com.ihrm.handler;

import com.ihrm.entity.Result;
import com.ihrm.entity.ResultCode;
import com.ihrm.exception.CommonException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result error(HttpServletRequest request, HttpServletResponse response, Exception e){
        if(e.getClass() == CommonException.class) {
            //类型转型
            CommonException ce = (CommonException) e;
            Result result = new Result(ce.getResultCode());
            return result;
        }else{
            Result result = new Result(ResultCode.SERVER_ERROR);
            return result;
        }
    }
}
