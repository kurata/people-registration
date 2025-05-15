package br.com.aqueteron.people.registration.api.operation;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Component
@Slf4j
public class OperationWebFilter extends HttpFilter {

    private final OperationService operationService;

    @Override
    protected void doFilter(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain chain
    ) throws IOException, ServletException {
        LocalDateTime initialDateTime = LocalDateTime.now();
        super.doFilter(request, response, chain);
        Operation operation = new Operation(UUID.randomUUID(), initialDateTime, LocalDateTime.now(), request.getMethod(), request.getServletPath(), response.getStatus());
        log.debug(operation.toString());
        this.operationService.sendOperation(operation);
    }

}
