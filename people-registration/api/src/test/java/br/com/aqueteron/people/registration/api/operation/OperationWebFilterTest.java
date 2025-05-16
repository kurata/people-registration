package br.com.aqueteron.people.registration.api.operation;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OperationWebFilterTest {

    @InjectMocks
    private OperationWebFilter operationWebFilter;

    @Mock
    private OperationService operationService;

    @Test
    void shouldDoFilter() throws ServletException, IOException {
        HttpServletRequest requestMock = mock();
        HttpServletResponse responseMock = mock();
        FilterChain chainMock = mock(FilterChain.class);

        this.operationWebFilter.doFilter(requestMock, responseMock, chainMock);
        verify(operationService).sendOperation(any());
    }
}
