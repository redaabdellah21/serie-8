package exo18;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;

public class PersonInputStream extends FileInputStream{
    private FileInputStream file;

    public PersonInputStream(FileInputStream fis) {
        super(FileDescriptor.in);
        this.file = fis;
    }
    public List<Person> readPeople(){

        try (InputStream inputStream =this.file;
             ObjectInputStream objectInputStream= new ObjectInputStream(inputStream)) {
            @SuppressWarnings("unchecked")
            List<Person> people = (List<Person>)objectInputStream.readObject();
            return people;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
