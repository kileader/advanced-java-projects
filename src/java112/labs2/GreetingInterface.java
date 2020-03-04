package java112.labs2;

public interface GreetingInterface {

    default String createGreeting(String person, String greeting) {
        return greeting + ", " + person + "!";
    }
    
}
