import java.io.FileNotFoundException;


public class BoardFactory {

    public static BoardReader getBoardReader (String file) throws FileNotFoundException {
        int indexFile = file.lastIndexOf('.');

        if (file.substring(indexFile).equals(".sdk")) {
            return new SDKBoardReader(file);
        }else if (file.substring(indexFile).equals(".ss")) {
            return new SSBoardReader(file);
        }
        throw new UnsupportedOperationException("File format not supported.");
    }
}
