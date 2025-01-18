/**
 Sample exception handler for the application.
 <p>This class handles exceptions thrown by any controller in the application.</p>
 <p>Author: Suvam Mohapatra</p>
 <p>Email: suvam.mohapatra@sita.aero</p>
 */
package com.jpa.ecomm_ops.web.controlleradvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class SampleExceptionHandler {

    /**
     * Handles all exceptions and returns a generic error message.
     *
     * @param ex the exception that was thrown
     * @return an error message
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleAllExceptions(Exception ex) {
        return ex.getMessage();
    }
}
