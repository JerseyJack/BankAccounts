/**
 * The bank account application is called through the Application class.
 * This class is where the main method is found. This class has two 
 * methods that are called through the main method. One runs through 
 * scenarios for the checking account, and one for the savings account. 
 * 
 * @author Jack Reynolds
 * @version 1.0
 * @since 02/04/2021
 */
public class Application
{
    
    /** 
     * Main method. The application starts here. 
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        checkingAccount();
        savingsAccount();
    }

    /**
     * The checkingAccount method creates a CheckingAccount object.
     * It then uses methods from the CheckingAccount class to run 
     * through different scenarios using a variety of values to test
     * its functionality. 
     */
    private static void checkingAccount()
    {
        //Create checking account object
        CheckingAccount checking = new CheckingAccount("4984 1198 7184 1856", "Moe Knee", 12000.00);

        //Output the account information
        System.out.println(checking.getAccountInformation());

        //Scenario: Normal deposit
        System.out.println(checking.deposit(150.00));

        //Scenario: Attepmting to deposit a minus value
        System.out.println(checking.deposit(-100.00));

        //Scenario: Normal withdrawal
        System.out.println(checking.withdrawal(200.00));

        //Scenario: Withdrawal that results in overdraft
        System.out.println(checking.withdrawal(12200.00));

        //Scenario: Attempting to withdraw a minus value
        System.out.println(checking.withdrawal(-200.00));
    }

    /**
     * The savingsAccount method creates a CheckingAccount object.
     * It then uses methods from the SavingsAccount class to run 
     * through different scenarios using a variety of values to test
     * its functionality. 
     */
    private static void savingsAccount()
    {
        //Create a savings account object
        SavingsAccount savings = new SavingsAccount("1846 1846 8354 6845", "Anita Dollah", 900.00);

        //Output account information
        System.out.println(savings.getAccountInformation());

        //Scenario: Normal deposit
        System.out.println(savings.deposit(50.00));

        //Scenario: Attempting to deposit a minus value
        System.out.println(savings.deposit(-100.00));

        //Scenario: Withdrawal that results in overdraft
        System.out.println(savings.withdrawal(1000.00));

        //Scenario: Normal withdrawal
        System.out.println(savings.withdrawal(800.00));

        //Scenario: Attempting to withdraw a minus value
        System.out.println(savings.withdrawal(-100.00));

        //Scenario: Adding interest to the balance
        System.out.println(savings.addInterest(0.2));

        //Scenario: Attemption to use the wrong interest convention
        System.out.println(savings.addInterest(2));
    }
}