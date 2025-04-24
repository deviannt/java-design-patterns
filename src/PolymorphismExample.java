class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("The dog barks: Woof-woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("The cat meows: Meow-meow!");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal animal = new Dog();

        animal.makeSound();

        animal = new Cat();

        animal.makeSound();
        }
    }

