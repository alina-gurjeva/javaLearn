/* JAVA-1 lesson7
@version 29.01.2022
@author Gurjeva AD
* */

package lesson7;

import java.util.Random;

public class Lesson7 {

    public static void main(String[] args) {
        int nCats = 10;

        Cat[] cats = new Cat[10];
        Random random = new Random();
        for (int i=0; i<nCats; i++){
            cats[i] = new Cat(String.valueOf(random.nextInt(10000)), random.nextInt(10));
        }
        Plate plate = new Plate(random.nextInt(50));
        for (Cat cat: cats) cat.eat(plate);
        for (Cat cat: cats) System.out.println(cat);

        Cat catFull = new Cat("fullCat", 10);

        Plate plate1 = new Plate(11);

        catFull.eat(plate1);
        catFull.eat(plate1);  // it is not hungry

        System.out.println(plate1);

    }


}

class Cat {
    final String name;
    int appetite;
    boolean isFull = false;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    @Override
    public String toString(){
        return name + ": " + (isFull? "full":"hungry" )+ " , his appetite is " + appetite;
    }

    void eat(Plate plate){
        if (isFull) System.out.println(name + " is not hungry");
        else if (plate.getFood() < appetite) System.out.println("too few food....");
        else {
            plate.takeFood(appetite);
            System.out.println(name + " " + "ate");
            isFull = true;
        }
    }
}

class Plate{
    int food;
    Plate(int food){
        this.food = food;
    }
    int getFood(){
        return this.food;
    }
    void takeFood(int n){
        if (n > food) food = 0;
        else food -= n;
    }
    void putFood(int n){
        food += n;
    }
    @Override
    public String toString(){
        return food + " on this plate";
    }
}
