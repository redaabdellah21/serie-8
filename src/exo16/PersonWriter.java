package exo16;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.function.Function;

public class PersonWriter {
	Function <Person, String> stringfromperson= (Person p) -> {
		StringBuilder str= new StringBuilder();
		str.append(p.getFirstName()+", "+p.getLastName()+", "+p.getAge()+"\n");
		return str.toString();
	};
	
	
	public void write (List <Person> people, String filename) {
		File file=new File(filename);
		try(Writer writer =new FileWriter(file,true);BufferedWriter bufferedwriter=new BufferedWriter(writer);)
				{
			for(Person p:people) {
				bufferedwriter.write(stringfromperson.apply(p));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
}
}