package pl.pjwstk.build;

public class NoSuchOptionException extends Exception {
    public NoSuchOptionException() {
    }

    public NoSuchOptionException(String message) {
        super(message);
    }
}
