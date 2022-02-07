package pro.sky.java.course2.questiongenerator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

    public BadRequestException(){
        super("Запрошено слишком большое количество запросов");
    }
}
