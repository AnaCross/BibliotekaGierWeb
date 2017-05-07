package pl.wgrel.repository;

public class NoSuchGraException extends Exception {
	private static final long serialVersionUID = -8555511053844242536L;

    public NoSuchGraException(String string) {
		super(string);
	}

	public NoSuchGraException() {
	}
}
