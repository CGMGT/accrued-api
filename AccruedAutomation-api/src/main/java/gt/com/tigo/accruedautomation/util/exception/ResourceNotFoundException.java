package gt.com.tigo.accruedautomation.util.exception;

public class ResourceNotFoundException extends TigoException {

    private static final  String MESSAGE = "No se ha podido encontrar el recurso solicitado.";

    public ResourceNotFoundException() {
        super(MESSAGE);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
