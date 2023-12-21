package gt.com.tigo.accruedautomation.util.exception;

public class ResourceCreateException extends TigoException {

    private static final  String MESSAGE = "No se ha podido crear el recurso.";

    public ResourceCreateException() {
        super(MESSAGE);
    }

    public ResourceCreateException(String message) {
        super(message);
    }

}
