/**
 * The CheckingAccount class is a subclass of BankAccount. The checking
 * account can be overdrawn is a withdrawal withdraws more money that
 * is available in the account.  
 * 
 * @author Jack Reynolds
 * @version 1.0
 * @since 02/04/2021
 */
public class CheckingAccount extends BankAccount
{
    /**
     * Constuctor method for the CheckingAccount class. 
     * 
     * @param accountNumber
     * @param accountName
     * @param accountBalance
     */
    public CheckingAccount(String accountNumber, String accountName, double accountBalance) 
    {
        super(accountNumber, accountName, accountBalance);
        this.accountType = AccountType.CheckingAccount;
    }

    /** 
     * In CheckingAccount, the inherited withdrawal method is overidden to 
     * account for situations where the account goes overdrawn. The checking 
     * account is allowed to be overdrawn, so after doing the initial check 
     * for an invalid value, the withdrawal will happen regardless, but the 
     * user will be alerted if the account is now overdrawn.
     * 
     * @param withdrawalAmount
     * @return String of the withdrawal receipt
     */
    @Override
    public String withdrawal(double withdrawalAmount)
    {
        //First check for invalid minus value.
        if (withdrawalAmount < 0)
        {
            return String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\nYou cannot withdraw negative values of money.\n\n-----------------------------");
        }
        
        //Withdraw from the account balance
        this.accountBalance -= withdrawalAmount;

        //Check if the account has gone overdrawn
        if (this.isOverdrawn(this.getAccountBalance() - withdrawalAmount))
        {
            //Alert the user that the account has gone overdrawn
            String overdrawn = String.format("Your checking account is now overdrawn");
            return String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\n%s\n\n%s \nWithdrawal Amount: £%s \nNew Balance: £%s\n\n-----------------------------", overdrawn, this.accountType(), withdrawalAmount, this.accountBalance);
        }
        else
        {
            //If the account is not overdrawn the withdrawal will go through as normal
            return String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\n%s \nWithdrawal Amount: £%s \nNew Balance: £%s\n\n-----------------------------",this.accountType,withdrawalAmount, this.accountBalance);
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
