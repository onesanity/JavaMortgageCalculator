package FirstProgram;

public class CleanCoding {
    public static void main(String[] args){
        String message = greetUser("Alina", "Nguyen");

    }
    public static String greetUser(String firstName, String lastName){
        return "Hello " + firstName + " " + lastName;
        //we need to call the greetUser from the main method
    }
}
