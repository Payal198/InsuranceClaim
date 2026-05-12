package com.example.demo.exception;
 
import java.util.HashMap;
import java.util.Map;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
 
import com.example.demo.exception.ControllerException;
 
@RestControllerAdvice
public class GlobalExceptionHandler {
 
	// Handle validation exceptions (400 Bad Request)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errorsMap = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorsMap.put(fieldName, errorMessage);
        });
        return errorsMap;
    }
 
    
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ControllerException.class) 
    public Map<String, String> ControllerException(ControllerException ex) {
        Map<String, String> errorsMap = new HashMap<>();
        errorsMap.put("error", "Purchase Conflict: " + ex.getMessage());
        return errorsMap;
    }
 
 
    // Handle resource not found (404 Not Found)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NullPointerException.class) 
    public Map<String, String> handleResourceNotFoundException(NullPointerException ex) {
        Map<String, String> errorsMap = new HashMap<>();
        errorsMap.put("error", "Not Found: " + ex.getMessage());
        return errorsMap;
    }
 
    // Handle bad request (400 Bad Request)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class) 
    public Map<String, String> handleBadRequestException(IllegalArgumentException ex) {
        Map<String, String> errorsMap = new HashMap<>();
        errorsMap.put("error", "Bad Request: " + ex.getMessage());
        return errorsMap;
    }
 
    
    // Handle general exceptions (500 Internal Server Error)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Internal Server Error: " + ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}