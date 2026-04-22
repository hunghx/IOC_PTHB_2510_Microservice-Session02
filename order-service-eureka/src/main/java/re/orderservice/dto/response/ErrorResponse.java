package re.orderservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class ErrorResponse<T> {
    private final LocalDateTime timestamp= LocalDateTime.now();
    private T message;
    private int status;
    private String error;
    private String path;
}
