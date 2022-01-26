/* JAVA-1 lesson5
@version 25.01.2022
@author Gurjeva AD
* */

package lesson5;

import java.util.Random;

public class Lesson5 {
    public static void main(String[] args) {
        int id = 199999;
        Employee[] ems = new Employee[5];
        Random rand = new Random();

//        Создать массив из 5 сотрудников.
        for (int i=0; i<5; i++){
            ems[i] = new Employee(String.valueOf(rand.nextInt(id)),
                    String.valueOf(rand.nextInt(id)),  // формально, в задаче не запрещено давать "числовые" имена
                    String.valueOf(rand.nextInt(id)),
                    rand.nextInt(60),
                    String.valueOf(rand.nextInt(id)),
                    rand.nextInt(200000),
                    String.valueOf(rand.nextInt(id)),
                    String.valueOf(rand.nextInt(id))
                    );
        }

//        С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (Employee e: ems){
            if (e.getAge() > 40) System.out.println(e);
        }
    }
}



//1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
class Employee{
    private String name;
    private String surname;
    private String patronymic;
    private int age;

    private String jobPosition;
    private int salary;

    private String email;
    private String phone;
//    2. Конструктор класса должен заполнять эти поля при создании объекта.
    public Employee(String name,
                    String surname,
                    String patronymic,
                    int age,
                    String jobPosition,
                    int salary,
                    String email,
                    String phone){
        this.setName(name);
        this.setSurname(surname);
        this.setPatronymic(patronymic);
        this.setAge(age);
        this.setJobPosition(jobPosition);
        this.setSalary(salary);
        this.setEmail(email);
        this.setPhone(phone);
    }
//    Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.

    @Override
    public String toString(){
        return "name: " + this.getName() + "\n" +
        "surname: " + this.getSurname() + "\n" +
        "patronymic: " +  this.getPatronymic() + "\n" +
        "age: " +  this.getAge() + "\n" +
        "jobPosition: " +  this.getJobPosition() + "\n" +
        "salary: " +  this.getSalary() + "\n" +
        "email: " +  this.getEmail() + "\n" +
        "phone: " +  this.getPhone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
