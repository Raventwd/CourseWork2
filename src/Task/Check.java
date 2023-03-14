package Task;

import Exceptions.IncorrectArgumentException;

public class Check {
    public static String checkString(String str) throws IncorrectArgumentException {
        if (str == null || str.isEmpty() || str.isBlank()){
throw new IncorrectArgumentException("Некорректный формат данных");
        }else{
            return str;
        }
    }
}
