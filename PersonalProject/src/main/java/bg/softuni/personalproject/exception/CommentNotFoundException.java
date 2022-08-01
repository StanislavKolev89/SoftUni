package bg.softuni.personalproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommentNotFoundException extends RuntimeException{
    private final Long id;
}
