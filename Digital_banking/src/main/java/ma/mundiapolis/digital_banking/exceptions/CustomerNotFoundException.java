package ma.mundiapolis.digital_banking.exceptions;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message){
        super(message);
    }
}
