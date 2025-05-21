package br.com.aqueteron.people.registration.api.configuration;

import br.com.aqueteron.people.registration.api.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ProblemDetail> handleException(final BusinessException businessException) {
        log.warn(businessException.getMessage(), businessException);
        return ResponseEntity.of(buildProblemDetail(businessException.getHttpStatus(), businessException)).build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ProblemDetail> handleException(final IllegalArgumentException illegalArgumentException) {
        log.warn(illegalArgumentException.getMessage());
        return ResponseEntity.of(buildProblemDetail(HttpStatus.BAD_REQUEST, illegalArgumentException)).build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleException(final Exception exception) {
        log.warn(exception.getMessage(), exception);
        return ResponseEntity.of(buildProblemDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception)).build();
    }

    private ProblemDetail buildProblemDetail(final HttpStatus httpStatus, final Exception exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, exception.getMessage());
        problemDetail.setProperty("trace", ExceptionUtils.getStackTrace(exception));
        return problemDetail;
    }
}
