package service.Auth;

public class NoUniqueEmailException extends Exception{
    public NoUniqueEmailException(String message) {
        super(message);
    }
}
