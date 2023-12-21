package gt.com.tigo.accruedautomation.util.exception;

public class ResourceImportException extends TigoException {

    private static final String MESSAGE = "Error al importar los registros.";

    public ResourceImportException() {
        super(MESSAGE);
    }

    public ResourceImportException(String message) {
        super(message);
    }

}
