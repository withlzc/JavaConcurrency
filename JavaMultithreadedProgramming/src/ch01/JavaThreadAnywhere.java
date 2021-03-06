package ch01;

/**
 * @Author: withlzc
 * @Description:
 * @Date: Created in 2019/1/15 0015 17:17
 */
public class JavaThreadAnywhere {

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        String currentThreadName = currentThread.getName();

        System.out.printf("The main method was executed by thread: %s",
                currentThreadName);

        Helper helper = new Helper("Java Thread Anywhere");
        helper.run();
    }

    static class Helper implements Runnable {
        private String message;

        public Helper(String message) {
            this.message = message;
        }

        private void doSomething(String message) {
            Thread currentThread = Thread.currentThread();
            String currentThreadName = currentThread.getName();
            System.out.printf("The doSomething method was executed by thread: %s",
                    currentThreadName);
            System.out.println("Do something with " + message);
        }

        @Override
        public void run() {
            doSomething(message);
        }
    }

}
