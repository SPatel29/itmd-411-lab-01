import java.util.Scanner;

/*
    AccountHolderTest class has the main function that has all the driver code
    This code creates an Account object and interacts with the user using that object
    Error handling is also done, in case user types something weird
 */
public class AccountHolderTest {

    /*
        The function prints the menu option for users to interact with
        The number they type is returned to main to use
     */
    public static int menu() {
        System.out.println("\nWelcome to the Bank of IIT!\n");
        System.out.println("================================");
        System.out.println("Please select a following option:");
        System.out.println("1. Make a deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Show Current Balance");
        System.out.println("4. Quit");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    /*
        The main function creates the account object
     */
    public static void main(String[] args) {
        double amount;
        int option;
        Scanner scan_obj = new Scanner(System.in);
        AccountHolder account;
        boolean done = false;

        System.out.println("Please enter a starting amount");
        amount = scan_obj.nextDouble();
        account = new AccountHolder(amount);

        while (!done) {
            option = menu();
            if (option == 1) {
                System.out.println("Please enter deposit amount");
                account.deposit(scan_obj.nextDouble()); //accepts user input and passes it in to deposit
            } else if (option == 2) {
                System.out.println("Please enter withdrawal amount");
                account.withdrawal(scan_obj.nextDouble()); //accepts user input and passes it in to withdrawal
            } else if (option == 3) {
                account.monthlyInterest();
                account.display();
            } else {
                System.out.println("Goodbye!");
                done = true;
            }
        }
        scan_obj.close();
    }
}


