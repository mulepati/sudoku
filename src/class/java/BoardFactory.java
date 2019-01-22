import java.io.FileNotFoundException;


public class BoardFactory {

    public static BoardReader getBoardReader (String file) throws FileNotFoundException {
        if(file.substring(6).equals(".sdk")){
            return new SDKBoardReader(file);
        }else if(file.substring(6).equals(".ss")){
            return new SSBoardReader(file);
        }
        return null;
    }
}
