package br.com.psergiopoli.ilist.controller;

import br.com.psergiopoli.ilist.exceptions.IListExpcetion;
import br.com.psergiopoli.ilist.util.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ErrorHandlerController.class);

    @ExceptionHandler(IListExpcetion.class)
    public final ResponseEntity<Message> handleUserNotFoundException(IListExpcetion ex) {
        Message message = new Message(ex.getMessage(), ex.getStatus().value());
        logger.error("Handling error: "+ex.getMessage(), ex);
        return new ResponseEntity<Message>(message, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Message> handlerNullPointerException(Exception ex) {
        Message message = new Message(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        logger.error("Handling error: "+ex.getMessage(), ex);
        return new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}