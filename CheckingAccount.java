public class CheckingAccount extends BankAccount
{
    private AccountType accountType = AccountType.CheckingAccount;

    protected String accountNumber, accountName;
    protected double accountBalance;

    protected CheckingAccount(String accountNumber, String accountName, double accountBalance) 
    {
        super(accountNumber, accountName, accountBalance);
    }

    @Override
    protected String accountType()
    {
        String output = String.format(String.valueOf("Account type: " + this.accountType));
        return output;
    }

    @Override
    public String withdrawal(double withdrawalAmount)
    {
        String output = "";
        double newAmount = 0;

        if (this.isOverdrawn(this.getAccountBalance() - this.withdrawalAmount))
        {
            newAmount = accountBalance - withdrawalAmount;
            String overdrawn = String.format("Your checking account is now overdrawn");
            output = String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\n%s\n\n" + this.accountType() + "\nAccount Balance: £%s \nWithdrawal Amount: £%s \nNew Amount: £%s \n\n-----------------------------", overdrawn, this.accountBalance, this.withdrawalAmount, newAmount);
        }
        else
        {
            newAmount = accountBalance - withdrawalAmount;
            output = String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\n" + this.accountType() + "\nAccount Balance: £%s \nWithdrawal Amount: £%s \nNew Amount: £%s \n\n-----------------------------", this.accountBalance, this.withdrawalAmount, newAmount);
        }
        return output; 
    }

    public AccountType getAccountType()
    {
        return this.accountType;
    }

    public boolean isOverdrawn(double accountBalance)
    {
        if (this.accountBalance < 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
}
