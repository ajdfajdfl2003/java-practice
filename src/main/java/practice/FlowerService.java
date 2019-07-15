package practice;

class FlowerService {
    private final IPerson farmer;

    FlowerService(IPerson farmer) {
        this.farmer = farmer;
    }

    void run() {
        this.farmer.doSomething();
    }
}
