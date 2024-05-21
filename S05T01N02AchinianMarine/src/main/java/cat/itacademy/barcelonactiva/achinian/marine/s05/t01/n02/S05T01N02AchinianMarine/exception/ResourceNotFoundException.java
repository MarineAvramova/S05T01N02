package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
