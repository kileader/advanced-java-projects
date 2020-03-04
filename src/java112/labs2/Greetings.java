package java112.labs2;

public class Greetings implements GreetingInterface {

    public static void main(String[] args) {
        Greetings greetings = new Greetings();
        System.out.println(greetings.createGreeting("Hey there", "Randy"));
    }
}
