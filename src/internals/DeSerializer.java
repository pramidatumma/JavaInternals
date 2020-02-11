package internals;

import java.lang.reflect.Field;

import static java.lang.String.format;

public class DeSerializer {
    public <T> Void deSerialize(String json, T returnObj) {
        try {
            String delims = "[ :={}]";
            String[] tokens = json.split(delims);

            for (int j=0; j< tokens.length; j++) {
                System.out.println(tokens[j]);
                for (Field field : returnObj.getClass().getDeclaredFields()) {
                    if (tokens[j].equals(field.getName())) {
                        field.setAccessible(true);
                        //Get the next word or token
                        String value = tokens[++j];
                        //Convert it in to fields type
                        //Set the field
                        field.set(returnObj, value);
                    }
                }
            }

            return null;

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
