package com.aloinopsis.studies_spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        code = HttpStatus.NOT_FOUND,
        reason = "Użytkownik nie odnaleziony"
)

public class UserNotFoundException extends RuntimeException {
}
