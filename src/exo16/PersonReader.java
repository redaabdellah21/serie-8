package exo16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonReader {
	Function <String, Person> personfromstring= (String s) -> {
		Person person = new Person();
		String separator= ", ";
		String[] words = s.split(separator);
		int i=0;
		person.setLastName(words[i]);
		person.setFirstName(words[i+1]);
		person.setAge(Integer.parseInt(words[i+2]));
		return person;
	};
	
	public List<Person> read (String filename) {
		File file= new File (filename);
		List <Person> persons = new ArrayList <Person>();
		try(Reader reader=new FileReader(file);BufferedReader bufferedreader=new BufferedReader(reader);)
				{
			List <String> lines= bufferedreader.lines().filter(s -> s.startsWith("#")!=true).collect(Collectors.toList());
			for (String str: lines) {
				persons.add(personfromstring.apply(str));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return persons;
	}
}
