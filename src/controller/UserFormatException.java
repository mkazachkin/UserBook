package controller;

public class UserFormatException extends Throwable {
    public UserFormatException () { super(); }
    public UserFormatException(String message) { super(message); }
    public UserFormatException(String message, Throwable cause) { super(message, cause); }
    public UserFormatException(Throwable cause) { super(cause); }
}
