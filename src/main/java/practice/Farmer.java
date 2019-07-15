package practice;

public class Farmer implements IPerson {
    @Override
    public void doSomething(Student student) {
        System.out.println("Planting!!!!" + student.getName());
    }
}
