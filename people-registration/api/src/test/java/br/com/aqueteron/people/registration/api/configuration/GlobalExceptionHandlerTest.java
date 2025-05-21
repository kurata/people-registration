package br.com.aqueteron.people.registration.api.configuration;

import br.com.aqueteron.people.registration.api.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    void shouldHandleBusinessException() {
        BusinessException businessException = ExceptionStub.createBusinessException();

        ResponseEntity<ProblemDetail> responseEntity = this.globalExceptionHandler.handleException(businessException);

        assertNotNull(responseEntity);
        assertEquals(businessException.getHttpStatus().value(), responseEntity.getStatusCode().value());
        ProblemDetail problemDetail = responseEntity.getBody();
        assertNotNull(problemDetail);
        assertEquals(businessException.getHttpStatus().value(), problemDetail.getStatus());
        assertEquals(businessException.getMessage(), problemDetail.getDetail());
    }

    @Test
    void shouldHandleException() {
        Exception exception = ExceptionStub.createException();

        ResponseEntity<ProblemDetail> responseEntity = this.globalExceptionHandler.handleException(exception);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        ProblemDetail problemDetail = responseEntity.getBody();
        assertNotNull(problemDetail);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), problemDetail.getStatus());
        assertEquals(exception.getMessage(), problemDetail.getDetail());
    }

    @Test
    void shouldHandleIllegalArgumentException() {
        IllegalArgumentException illegalArgumentException = ExceptionStub.createIllegalArgumentException();

        ResponseEntity<ProblemDetail> responseEntity = this.globalExceptionHandler.handleException(illegalArgumentException);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        ProblemDetail problemDetail = responseEntity.getBody();
        assertNotNull(problemDetail);
        assertEquals(HttpStatus.BAD_REQUEST.value(), problemDetail.getStatus());
        assertEquals(illegalArgumentException.getMessage(), problemDetail.getDetail());
    }
}
