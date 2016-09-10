package se.acme.util;

import java.util.Map;

public class CommonUtils {

    private CommonUtils() {
        //Intentianally hidden constructor
    }

    public static int compareLong(Map.Entry<String, Long> entry1, Map.Entry<String, Long> entry2) {
        if (entry1.getValue() - entry2.getValue() > 0){
            return -1;
        } else if (entry1.getValue() - entry2.getValue() == 0){
            return 0;
        }
        else {
            return 1;
        }
    }

}
