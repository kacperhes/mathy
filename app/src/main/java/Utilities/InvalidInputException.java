package Utilities;

import java.io.IOException;

/**
 * Created by kacpe on 22.07.2017.
 */

public class InvalidInputException extends IOException {
    public InvalidInputException(){}
    public InvalidInputException(String gripe){
        super(gripe);
    }
}
