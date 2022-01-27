package lesson6;

public class Lesson6 {
    public static void main(String[] args) {
        // tests
        Cat cat1 = new Cat("cat1", 20, 100);
        Cat cat2 = new Cat("cat1", 100);

        cat1.swim(50);
        cat2.run(200);

        cat1.setMaxSwim(200);
        cat2.setMaxRun(200);
        cat2.run(200);

        Dog dog1 = new Dog("dog1", 100, 200);
        dog1.swim(300);
        dog1.setMaxSwim(500);
        dog1.swim(300);

        Animal[] animals = {new Cat("cat", 20), new Dog("dog", 20, 200)};
        for (Animal a: animals) a.swim(20);

        System.out.println(Animal.counter);  // 4. * Добавить подсчет созданных котов, собак и животных.
    }
}

interface iAnimal{
    void run(int s);
    void swim(int s);
}

abstract class Animal implements iAnimal{
    static int counter = 0;
    final String name;  // one name forever
    int maxSwim;  // can be trained
    int maxRun;  // can be trained

    Animal(String name, int maxSwim, int maxRun){
        counter++;
        this.name = name;
        this.maxSwim = maxSwim;
        this.maxRun = maxRun;
    }

    public void setMaxSwim(int maxSwim) {
        this.maxSwim = maxSwim;
    }

    public void setMaxRun(int maxRun) {
        this.maxRun = maxRun;
    }
    @Override  // because this is general for both: dog and cat classes => overrided here
    public void run(int s){
        if (s > this.maxRun) System.out.println(this.name +
                " can run only " + this.maxRun + " m.");
        else System.out.println(this.name + " run " + s + " m.");
    }
    @Override  // because there maybe other classes who can swim. not only dogs => overrided here
    public void swim(int s){
        if (s > this.maxSwim) System.out.println(this.name +
                " can swim only " + this.maxSwim + " m.");
        else System.out.println(this.name + " swim " + s + " m.");
    }
}

class Cat extends Animal{
    Cat(String name, int maxSwim, int maxRun){
        super(name, 0, maxRun);
        if(maxSwim > 0) System.out.println("Cats can't swim: maxSwim has been set to 0");
    }
    Cat(String name, int maxRun){
        super(name, 0, maxRun);
    }

    @Override
    public void swim(int s){
        System.out.println("cats can't swim");
    }

    @Override
    public void setMaxSwim(int maxSwim){
        System.out.println("cats can't swim");
    }
}

class Dog extends Animal{
    Dog(String name, int maxSwim, int maxRun){
        super(name, maxSwim, maxRun);
    }
}


