package practice;

class FlowerService {
    private final IPerson farmer;

    FlowerService(IPerson farmer) {
        this.farmer = farmer;
    }

    void run() {
        Student student = new Student("angus", 123);
        this.farmer.doSomething(student);
    }
}
