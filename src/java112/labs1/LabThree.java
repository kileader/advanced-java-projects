package java112.labs1;

public class LabThree {

    public static void main(String[] args) {

        if (args.length == 0 || args.length > 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            LabThree lab3 = new LabThree();
            lab3.run(args[0]);
        }
    }
    public void run(String param1) {
        System.out.println("input: " + param1);
    }
}
