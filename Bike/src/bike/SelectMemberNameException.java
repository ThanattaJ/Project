package bike;
public class SelectMemberNameException extends Exception {

    public SelectMemberNameException() {
        super("Don't have Member's name.");
    }

    public SelectMemberNameException(String message) {
        super(message);
    }
    
}
