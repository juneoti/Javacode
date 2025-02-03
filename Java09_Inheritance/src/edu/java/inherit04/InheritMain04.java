package edu.java.inherit04;

public class InheritMain04 {

	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.speak();
		
		Dog dog = new Dog();
		dog.speak();
		
		Cat cat = new Cat();
		cat.speak();
		
		Animal[] a = new Animal[2];
		a[0] = dog;
		a[1] = cat;
		for(int i = 0; i < a.length;i++) {
		a[i].speak();
		}
		
	}

}
