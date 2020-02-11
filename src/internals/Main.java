package internals;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Ram";
        person.age = 20;
        person.setSalary(200000);
        person.setId(1);
        Job myJob = new Job();
        myJob.companyName = "TW";
        myJob.title = "Con";
        person.job = myJob;
        person.favBooks = new ArrayList<String>();
        person.favBooks.add("Alchemist");
        person.favBooks.add("Kite Runner");
        person.favBooks.add("Steve jobs");
//
//        person.friends = new HashMap<Integer, String>();
//        person.friends.put(1,"Sudha");
//        person.friends.put(2,"Gautami");
//        person.friends.put(3,"Priya");

        Serializer serializer = new Serializer();
        String serializedString = serializer.serialize(person);
        System.out.println(serializedString);

//        Person newPerson = new Person();
//        DeSerializer deSerializer = new DeSerializer();
//        deSerializer.deSerialize(serializedString, newPerson);
//        System.out.println("The deSerialized output is");
//        System.out.println(newPerson.name);
    }
}
