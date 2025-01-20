package app.inventory.exception;

public class WarehouseNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public WarehouseNotFoundException(String message) {
		super(message);
	}
}
