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
        String output = String.format(String.valueOf("Account type: " + accountType));
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
