/**
 * The SavingsAccount class is a subclass of BankAccount. The savings
 * account cannot be overdrawn. The possibility of being overdrawn is
 * to be prevented. Furthermore, at the end of a month, savings
 * gain a percentage of interest at the end of the month. Therefore, 
 * SavingsAccount has a callable function to add interest onto the 
 * current account balance. 
 * 
 * @author Jack Reynolds
 * @version 1.0
 * @since 02/04/2021
 */
public class SavingsAccount extends BankAccount
{
    /**
     * Constructor method for the SavingsAccount class
     * 
     * @param accountNumber
     * @param accountName
     * @param accountBalance
     */
    public SavingsAccount(String accountNumber, String accountName, double accountBalance) 
    {
        super(accountNumber, accountName, accountBalance);
        this.accountType = AccountType.SavingsAccount;
    }

    
    /** 
     * In SavingsAccount, the withdrawal method is inherited and overridden
     * from BankAccounts. The savings account cannot be overdrawn, therefore
     * using the isOverdrawn, it is checked if the account will go overdrawn
     * if the withdrawal goes through. If it is overdrawn, the money will 
     * not be withdrawn from the account balance. If it isn't, the money will
     * come out as normal. Of course, prior to this, the method will still 
     * check for invalid minus values. 
     * 
     * @param withdrawalAmount
     * @return String of the withdrawl receipt
     */
    @Override
    public String withdrawal(double withdrawalAmount)
    {
        //Check for invalid minus values
        if (withdrawalAmount < 0)
        {
            return String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\nYou cannot withdraw negative values of money.\n\n-----------------------------");
        }

        //Check if the account will be overdrawn
        if (this.isOverdrawn(this.getAccountBalance() - withdrawalAmount))
        {
            //If the account would be overdrawn from the withdrawal, the user will be alerted and the money will not be taken
            String overdrawn = String.format("Your savings account cannot go overdrawn");
            return String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\n%s\n\n%s\nWithdrawal Amount: -£%s (Cannot withdraw)\nAccount Balance: £%s \n\n-----------------------------", overdrawn, this.accountType(), withdrawalAmount, this.accountBalance);
        }
        else
        {
            //If the account is not overdrawn from the withdrawal, the money will come out as usual
            this.accountBalance -= withdrawalAmount;
            return String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\n%s\nWithdrawal Amount: -£%s \nNew Account Balance: £%s \n\n-----------------------------",this.accountType(), withdrawalAmount, this.accountBalance);
        }
    }

    
    /** 
     * The addInterest method will be used to add interest, based on 
     * a percentage, when called. It will first check that the 
     * parameter passed in is valid to be used in the context of a 
     * percentage. The interest of the current balance is then 
     * calculated and added to the current balance. 
     * 
     * @param interest
     * @return String summary of the interest being added
     */
    public String addInterest(double interest)
    {
        //Check if a valid percentage is given.
        if(interest > 0 && interest < 1)
        {
            //If valid, calculate and add the interest to the balance
            this.accountBalance *= 1 + interest;
            return String.format("-----------------------------\n\nINTEREST ADDED\n\n%s\nInterest Added: %s\nAccount Balance: £%s \n\n\n-----------------------------",this.accountType(),interest, this.accountBalance);
    
        }
        else
        {
            //If invalid, alert the user of an invalid input
            return String.format("-----------------------------\n\nINTEREST NOT ADDED\n\nIncorrect interest measurement.\n\n-----------------------------");
        }
        
    }

    
    /** 
     * The isOverdrawn method is derived from the BankAccount super
     * class. It will take a double which, depending on if it is 
     * less than 0 or not, will determine if the account is overdrawn.
     * It will then return a boolean. 
     * 
     * @param moneyWithdrew
     * @return boolean for if the account is overdrawn
     */
    public boolean isOverdrawn(double moneyWithdrew)
    {
        //Check if the money falls below 0
        if (moneyWithdrew < 0)
        {
            //The account is overdrawn
            return true;
        }
        else
        {
            //The account is not overdrawn
            return false;
        }
    }
}