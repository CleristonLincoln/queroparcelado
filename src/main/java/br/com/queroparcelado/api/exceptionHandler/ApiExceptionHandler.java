package br.com.queroparcelado.api.exceptionHandler;

import br.com.queroparcelado.domain.exception.EntidadeNaoEncontrataException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EntidadeNaoEncontrataException.class)
    public ResponseEntity<?> tratarEntidadeNaoEncontradaException(EntidadeNaoEncontrataException e, WebRequest request){

        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(),
                HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if (body == null) {
            body = Problem.builder()
                    .title(status.getReasonPhrase())
                    .status(status.value())
                    .build();
        } else if (body instanceof String) {
            body = Problem.builder()
                    .title((String) body)
                    .status(status.value())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }


    private Problem createProblemBuilder(HttpStatus httpStatus, ProblemType problemType, String detail) {
        return Problem.builder()
                .detail(detail)
                .status(httpStatus.value())
                .data(LocalDateTime.now())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .build();
    }
}
