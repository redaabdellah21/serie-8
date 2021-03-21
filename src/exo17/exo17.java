package exo17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class exo17 {

	public static void main(String[] args) {
		
		System.out.println("\n Question 1: \n");
		System.out.println("Pour créer un buffer en mémoire, il faut utiliser la clase ByteArrayOutputStream \n");
		System.out.println("On doit utiliser la classe DataOutputStream qui est une décoration de OutputStream pour écrire des types prémitifs\n");
		System.out.println("\n Question 2 et 3: \n");
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
		String file = "files/newfile.bin";
		try(PersonOutputStream personOutputStream=new PersonOutputStream(new FileOutputStream(file))){
			personOutputStream.writeFields(perso);
			System.out.println("Check the file 'newfile.bin' \n");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n Question 4 et 5: \n");
        try (PersonInputStream personInput = new PersonInputStream(new FileInputStream(file))) {
            List<Person> perso1;
            perso1 = personInput.readFields();
            perso1.forEach(System.out::println);
        } catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
