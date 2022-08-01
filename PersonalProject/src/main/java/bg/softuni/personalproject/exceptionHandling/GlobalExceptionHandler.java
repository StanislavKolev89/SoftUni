package bg.softuni.personalproject.exceptionHandling;


import bg.softuni.personalproject.exception.ObjectNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ModelAndView globalHandler(ObjectNotFoundException onfe){
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}
