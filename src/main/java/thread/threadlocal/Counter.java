package thread.threadlocal;

class Counter extends ThreadLocal<Integer> {
    @Override
    protected Integer initialValue() {
        return 0;
    }
}
