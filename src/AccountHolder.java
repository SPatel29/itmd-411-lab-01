/*
    The AccountHolder class has fields annual rate and balance
    and methods such as deposit, withdrawal, monthly interest and display
    Each method is explained below
 */

public class AccountHolder {
    public static double annual_rate = 0.04;    //4% interest rate, static so each object shares this variable
    private double balance;

    /*
        No args constructor:

        Accepts no args, and initalizes field balance to be 0.0.
        This way we at least initalize our balance, regardless if user inputs something or not.
     */

    public AccountHolder() {
        balance = 0.0;
    }

    /*
        1 arg constructor. This constructor accepts the user inputted balance
        and then initializes the user input to field balance

        @param bal: user inputted balance
     */

    public AccountHolder(double bal) {
        if (bal >= 0)
            balance = bal;
        else
            throw new IllegalArgumentException("Please enter an initial withdrawal greater than or equal to 0");
    }

    /*
        This function accepts 1 arg called amount that is a double. This function deposits money
        by adding the balance and the amount user entered. A safety precaution I added in was to make sure
        user inputted balance is greater than 0, toa void any negative deposits.

        @param amount: user input that added to current balance
     */

    public void deposit(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Deposit must be non-negative!");
        else {
            balance += amount;
            System.out.println("Balance has been updated");
        }
    }

    /*
        This function accepts 1 arg called amount that is a double. This function withdraws money by
        subtracting the user inputted amount and current balance. Some safety precautions added were
        to make sure amount withdraw is lower than the current balance, to avoid making balance negative and 0.
        Another precaution I took was to make sure the balance will not drop to 50 once we withdraw an amount.

        @param amount: User input that is subtracted by current balance
     */
    public void withdrawal(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("\nPlease enter a withdrawal amount greater than 0.");
        else if (amount > balance)
            throw new IllegalArgumentException("\nWithdrawal amount exceeds current balance!");
        else if (balance - amount < 50)
            throw new IllegalArgumentException("\nWithdrawal will make balance below 50. Withdrawal failed.");
        else
            balance -= amount;
        System.out.println("\nWithdrawal is successful. Balance has been updated");
    }

    /*
        This function accepts no args. This function updates our balance, dependent on what the
        monthly interest rate is
     */

    public void monthlyInterest() {
        balance += balance * (annual_rate / 12.0);
    }

    /*
        This function accepts no args and prints out the current balance
        I made sure to make this function have a "final" declaration
        to avoid modifying anything. This function is only meant
        as a read only function
     */

    final public void display() {
        System.out.printf("Your balance with interest applied is: $%.2f \n", balance);
    }

}
