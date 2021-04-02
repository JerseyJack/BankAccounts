/**
 * The BankAccount class is a superclass for all account types for the bank system. 
 * It implements the IAccount interface. Subclasses, CheckingAccount and 
 * SavingsAccount will inherit the methods and attributes. 
 * 
 * @author Jack Reynolds
 * @version 1.0
 * @since 02/04/2021
 */
public abstract class BankAccount implements IAccount
{

    //Declare attributes of the class
    private String accountNumber, accountName;
    protected double accountBalance, depositAmount, withdrawalAmount;
    protected AccountType accountType;

    /**
     * Constructor method for the BankAccounts class.
     * 
     * @param accountNumber
     * @param accountName
     * @param accountBalance
     */
    protected BankAccount(String accountNumber, String accountName, double accountBalance) 
    {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }
    
    /** 
     * The AccountType method will display the account type in a string format.
     * 
     * @return String displaying account type.
     */
    public String accountType()
    {
        //Output the account type in a string
        return String.format("Account Type: %s", this.accountType);
    }

    /** 
     * The getAccountInformation method will display all crucial information 
     * regarding the account when it is called.
     * 
     * @return String displaying all account information.
     */
    public String getAccountInformation()
    {
        //Output the account information in a string
        return String.format("-----------------------------\n\nACCOUNT INFORMATION\n\n%s \nAccount Number: %s \nAccount Holder Name: %s \nAccount Balance: £%s \n\n-----------------------------",this.accountType(), this.accountNumber, this.accountName, this.accountBalance);
    }

    /**
     * The deposit method will accept a double specifying the amount the 
     * user wishes to deposit into the account. The method will first
     * check whether the number is valid before accepting it and adding it 
     * to the balance. 
     * 
     * @param depositAmount
     * @return String success response
     */
    public String deposit(double depositAmount)
    {
        //Check for invalid minus values
        if (depositAmount < 0)
        {
            //If the value is minus alert the user that the deposit cannot take place
            return String.format("-----------------------------\n\nDEPOSIT RECIEPT\n\nYou cannot deposit negative values of money.\n\n-----------------------------");
        }
        else 
        {
            //If the value is valid deposit the money
            this.accountBalance += depositAmount;
            return String.format("-----------------------------\n\nDEPOSIT RECIEPT\n\n%s \nDeposit Amount: £%s \nNew Balance: £%s \n\n-----------------------------",this.accountType(),depositAmount, this.accountBalance);
        }
    }
    
    /** 
     * The withdrawal method will accept a doube specifying the amount the
     * user wishes to withdraw from the account. The method will first check
     * whether the number is valid before accepting it and deducting it from 
     * the balance.
     * 
     * @param withdrawalAmount
     * @return String success response
     */
    public String withdrawal(double withdrawalAmount)
    {
        //Check for invalid minus value
        if (withdrawalAmount < 0)
        {
            //If the value is invalid alert the user that the withdrawal cannot take place
            return String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\nYou cannot withdraw negative values of money.\n\n-----------------------------");
        }
        else
        {
            //If the value is valid withdraw the money
            this.accountBalance -= withdrawalAmount;
            return String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\n%s \nWithdrawal Amount: £%s \nNew Balance: £%s \n\n-----------------------------",this.accountType(), withdrawalAmount, this.accountBalance);
        }
    }
    
    /** 
     * The getAccountNumber method returns the account number.
     * 
     * @return String accountNumber
     */
    public String getAccountNumber() 
    {
        return this.accountNumber;
    }
    
    /** 
     * The getAccountName method returns the account holder's
     * name.
     * 
     * @return String accountName
     */
    public String getAccountName()
    {
        return this.accountName;
    }
    
    /** 
     * The getAccountBalance method returns the balance of
     * the account. 
     * 
     * @return double accountBalance
     */
    public double getAccountBalance()
    {
        return this.accountBalance;
    }
    
    /** 
     * The setAccountBalance method will set the account balance.
     * 
     * @param accountBalance
     */
    public void setAccountBalance(double accountBalance)
    {
        this.accountBalance = accountBalance;
    }
    
    /** 
     * The getAccountType method will return the account type
     * of the account. 
     * 
     * @return AccountType
     */
    public AccountType getAccountType()
    {
        return this.accountType;
    }

    /**
     * The isOverdrawn is an abstract method which is to be enforced
     * onto the derived classes. It will be used to check if a 
     * withdrawal will result in the account going overdrawn. 
     * 
     * @param accountBalance
     * @return boolean of whether the account will be overdrawn or not
     */
    protected abstract boolean isOverdrawn(double accountBalance);
}

