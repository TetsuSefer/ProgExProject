package GUI;

public class Main {
    public static void main(String[] args) {
        Account A = new Account("root","denizdeniz");
        //A.registration("Hundi3","Hundi3","Hundi3");
        //A.login("Hundi3","Hundi3");


        Pants pant = new Pants("Red Pants",99.99,"male","Short Pants");
        Pants pant2 = new Pants("Blue Pants",9.99,"female","Sweat Pants");
        Pants pant3 = new Pants("Green Pants",19.99, "male","Jeans");

        Jackets jack = new Jackets("Gucci Jacket",999.99,"female","Leatherjacket");
        Jackets jack2 = new Jackets("HundM Jacket",9.99,"male","Summer Jacket");




        // Überprüfen der Anmeldung
        //boolean loggedIn = account.login("testt", "password123");
        //System.out.println("Logged in: " + loggedIn);
    }
}
