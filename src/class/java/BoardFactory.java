
import java.io.FileNotFoundException;


public class BoardFactory {

    public static BoardReader getBoard (String file) throws FileNotFoundException {
        if(file.substring(6).equals(".sdk")){
            return new Board(file);
        }else if(file.substring(6).equals(".ss")){
            return new Board2(file);
        }
        return null;
    }
}
