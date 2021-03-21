package exo17;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class PersonOutputStream extends FileOutputStream{
	private FileOutputStream file;
	
	Function <Person, byte[]> octetFromPerson= (Person p) -> {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream=new DataOutputStream(byteArrayOutputStream)) {
               dataOutputStream.writeUTF(p.getLastName());
               dataOutputStream.writeUTF(p.getFirstName());
               dataOutputStream.writeInt(p.getAge());
               return byteArrayOutputStream.toByteArray();
           } catch (IOException e) {
               e.printStackTrace();
           }

           return new byte[0];
	};
	
	public PersonOutputStream(FileOutputStream file){
		super(FileDescriptor.in);
		this.file = file;
	}
	public void writeFields(List <Person> people) {
		
		try (FileOutputStream os = this.file;
				DataOutputStream bos = new DataOutputStream(os);) {
			bos.writeInt(people.size());

				for (Person p : people) {
					bos.write(octetFromPerson.apply(p));
				}
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} 
	}
	

}
