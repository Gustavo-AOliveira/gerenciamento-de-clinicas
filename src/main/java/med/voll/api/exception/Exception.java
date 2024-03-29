package med.voll.api.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class Exception {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacao::new).toList());
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity errorDataIntegrityViolation(){
        String errorMessage = "Erro de integridade de dados: o registro já existe ou viola restrições de chave.";
            return ResponseEntity.badRequest().body(errorMessage);

    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity tratarEroBadCredentials(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais negadas");
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity tratarErroAuthentication(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity tratarErroAcessoNegado(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado");
    }
    @ExceptionHandler(ConsultaException.class)
    public ResponseEntity tratarErroAgendamento(ConsultaException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity tratarErroValidacao(ValidationException ex){
        ErrosResponse error = new ErrosResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.badRequest().body(error);

    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity tratarErroValidacao(IllegalArgumentException ex){
        ErrosResponse error = new ErrosResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
            return ResponseEntity.badRequest().body(error);
    }

    private record DadosErroValidacao(String campo, String mensagem){
        private DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}















