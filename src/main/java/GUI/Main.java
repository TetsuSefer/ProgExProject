    package GUI;

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] permissions = {"SELECT", "INSERT", "UPDATE", "DELETE"};

            Account A = new Account();
            A.grantPermissionsToAccount("Hans","Hans",permissions);
            //A.addAccountAndUser("LOL","LOL","LOL","LOL");


            scanner.close();
        }
    }