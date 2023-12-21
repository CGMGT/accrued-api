package gt.com.tigo.accruedautomation.util.exception;

public class RequesterNotFoundException extends TigoException {

    private static final  String MESSAGE = "El solicitante no existe en el sistema.";

    public RequesterNotFoundException() {
        super(MESSAGE);
    }

    public RequesterNotFoundException(String message) {
        super(message);
    }

}
