package app.inventory.exception;

public class WarehouseIdMismatchException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public WarehouseIdMismatchException(String message) {
		super(message);
	}

}
