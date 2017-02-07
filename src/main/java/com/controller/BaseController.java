package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alibaba.fastjson.JSON;
import com.common.constant.ResultModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.nio.charset.Charset;


public class BaseController {
	private static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    protected HttpHeaders headers = new HttpHeaders();

    @ModelAttribute
    protected void init() {

        MediaType mediaType = new MediaType("text", "html", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);
    }

    @ExceptionHandler(Exception.class)
    //统一异常处理
    public ResponseEntity<String> exceptionHandler(Exception ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ResultModel resultModel=new ResultModel();
        LOGGER.error("{}", ex);
        resultModel.setResultCode("系统异常");
		resultModel.setMessage(ex.getMessage());
        //TODO
        return new ResponseEntity<String>(JSON.toJSONString(resultModel), headers, HttpStatus.BAD_REQUEST);
    }
}
