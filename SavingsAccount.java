public class SavingsAccount extends BankAccount
{
    private AccountType accountType = AccountType.SavingsAccount;

    protected String accountNumber, accountName;
    protected double accountBalance;

    protected SavingsAccount(String accountNumber, String accountName, double accountBalance) 
    {
        super(accountNumber, accountName, accountBalance);
    }

    @Override
    public String accountType()
    {
        String output = String.format(String.valueOf("Account type: " + this.accountType));
        return output;
    }

    @Override
    public String withdrawal(double withdrawalAmount)
    {
        String output = "";
        double newAmount = 0;

        if (this.canWithdraw(getAccountBalance() - this.withdrawalAmount))
        {
            String overdrawn = String.format("Your savings account cannot go overdrawn");
            output = String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\n%s\n\n" + accountType() + "\nAccount Balance: £%s \nWithdrawal Amount: £%s \nNew Amount: £%s \n\n-----------------------------", overdrawn, accountBalance, withdrawalAmount, newAmount);
        }
        else
        {
            output = String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\n" + accountType() + "\nAccount Balance: £%s \nWithdrawal Amount: £%s \nNew Amount: £%s \n\n-----------------------------", accountBalance, withdrawalAmount, newAmount);
        }
        return output; 
    }

    public AccountType getAccountType()
    {
        return accountType;
    }

    public boolean canWithdraw(double accountBalance)
    {
        if (accountBalance < 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
}