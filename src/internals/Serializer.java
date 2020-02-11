package internals;

import java.lang.reflect.Field;
import java.util.List;

import static java.lang.String.format;

public class Serializer {
    public <T> String serialize(T source) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\n");
            for (Field field : source.getClass().getDeclaredFields()) {
                boolean annotationPresent = field.isAnnotationPresent(JsonIgnore.class);
//                System.out.println(String.format("The field is %s and the type is %s", field.getName(), field.getType()));
                if (!annotationPresent) {
                    field.setAccessible(true);
                    String value;
                    if (!field.getType().isPrimitive() && !(field.getType()==String.class)) {
                        if(field.getType()== List.class) {
                            stringBuilder.append(format("%s :[ %s ]\n", field.getName(), field.get(source)));

                        }
                        System.out.println(String.format("Type is List non-primitive %s", field.getName()));
                        value = serialize(field.get(source));
                        stringBuilder.append(format("%s :\n %s \n", field.getName(), value));
                    }
                    else {
                        if(field.getType()== List.class)
                            System.out.println(String.format("Type is List %s", field.getName()));
                        stringBuilder.append(format("%s : %s \n", field.getName(), field.get(source)));
                    }
                }
            }
            stringBuilder.append(" }");
            return stringBuilder.toString();

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
