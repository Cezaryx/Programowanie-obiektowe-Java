package wyj;
public class ExceptionDVD extends Exception {
    public ExceptionDVD(String line) {
        super("Invalid format on line ".concat(line));
    }
}
