package com.qin.controller.uitl;

import com.qin.pojo.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler
    public R doException(Exception ex) {
        //记录日志
        //通知运维
        //通知开发

        //控制台打印异常信息
        ex.printStackTrace();
        return new R(false,"服务器抽风了，请稍后再试！");
    }
}
