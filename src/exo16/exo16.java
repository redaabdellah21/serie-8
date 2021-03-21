package exo16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class exo16 {

	public static void main(String[] args) {
		PersonReader pr= new PersonReader();
		PersonWriter pr1= new PersonWriter();
		Function <String, Person> personfromstring = (String s) -> {
			Person person = new Person();
			String separator= ", ";
			String[] words = s.split(separator);
			int i=0;
			person.setLastName(words[i]);
			person.setFirstName(words[i+1]);
			person.setAge(Integer.parseInt(words[i+2]));
			return person;
		};
		System.out.println("\n Question 1 \n");
		System.out.println("Class Person has been created \n");
		String s=" Zidane, Zinedine, 47";
		System.out.println("\n Question 2 \n");
		System.out.println(personfromstring.apply(s));
		
		System.out.println("\n Question 3 \n");
		System.out.println(pr.read("files/file.txt"));
		
		System.out.println("\n Question 4 et 5 \n");
		System.out.println("Check the the file1.txt \n");
		List<Person> perso= new ArrayList<>();
		Person p1 = new Person ("Zineddine","Ziden",25);
		Person p2 = new Person ("Ronaldo","Jr",30);
		Person p3 = new Person ("Beckham","David",35);
		Person p4 = new Person ("Figo","Luis",40);
		Person p5 = new Person ("Casillas","Iker",45);
		Person tab[]= {p1,p2,p3,p4,p5};
		for(int i=0;i<tab.length;i++) {
			perso.add(tab[i]);
		}
		pr1.write(perso,"files/file1.txt");
	}

}
