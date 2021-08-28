package Problem;

public class Pro1114_按序打印 {

    public static void main(String[] args) {

    }

    class Foo {

        private final Object lock = new Object();
        private volatile boolean finish1 = false;
        private volatile boolean finish2 = false;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized (lock) {
                printFirst.run();
                finish1 = true;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (!finish1) {
                    lock.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                finish2 = true;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (!finish2) {
                    lock.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
            }
        }
    }
}
