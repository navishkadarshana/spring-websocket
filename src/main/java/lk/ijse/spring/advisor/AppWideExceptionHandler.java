package lk.ijse.spring.advisor;


import lk.ijse.spring.util.StandradResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

 @ExceptionHandler({RuntimeException.class})
 public ResponseEntity handlerException(RuntimeException ex){
     StandradResponse response = new StandradResponse(500, "Error", ex.getMessage());
     return new ResponseEntity(response, HttpStatus.OK);
 }

}
