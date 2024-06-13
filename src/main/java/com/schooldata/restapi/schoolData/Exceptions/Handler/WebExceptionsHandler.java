package com.schooldata.restapi.schoolData.Exceptions.Handler;

import com.schooldata.restapi.schoolData.Error.ApiError;
import com.schooldata.restapi.schoolData.Exceptions.StudentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class WebExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(StudentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleStudentException(final StudentException e) {
        log.error(e.getMessage() + " (" + e.getDetailedMessage() + ")", e);
        return new ApiError(HttpStatus.NOT_FOUND, e.getMessage(), e.getDetailedMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleGlobalException(final Exception e) {
        log.error(e.getMessage(), e);
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", e.getMessage());
    }
}
