public abstract class BankAccount
{
    protected String accountNumber, accountName;
    protected double accountBalance, depositAmount, withdrawalAmount;

    protected BankAccount(String accountNumber, String accountName, double accountBalance) 
    {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    protected String accountType()
    {
        String output = String.format("Account type not set...");
        return output;
    }

    protected String getAccountInformation()
    {
        String output = String.format("-----------------------------\n\nACCOUNT INFORMATION\n\n" + accountType() + "\nAccount Number: %s \nAccount Holder Name: %s \nAccount Balance: £%s \n\n-----------------------------", accountNumber, accountName, accountBalance);
        return output;
    }

    protected String deposit(double depositAmount)
    {
        double newAmount = accountBalance + depositAmount;
        String output = String.format("-----------------------------\n\nDEPOSIT RECIEPT\n\n" + accountType() + "\nAccount Balance: £%s \nDeposit Amount: £%s \nNew Amount: £%s \n\n-----------------------------", accountBalance, depositAmount, newAmount);
        return output;
    }

    protected String withdrawal(double withdrawalAmount)
    {
        double newAmount = accountBalance - withdrawalAmount;
        String output = String.format("-----------------------------\n\nWITHDRAWAL RECIEPT\n\n" + accountType() + "\nAccount Balance: £%s \nWithdrawal Amount: £%s \nNew Amount: £%s \n\n-----------------------------", accountBalance, withdrawalAmount, newAmount);
        return output;
    }

    protected String getAccountNumber() 
    {
        return this.accountNumber;
    }

    protected String getAccountName()
    {
        return this.accountName;
    }

    protected double getAccountBalance()
    {
        return this.accountBalance;
    }

    public void setAccountBalance(double accountBalance)
    {
        this.accountBalance = accountBalance;
    }

    //Setting up the abstract class to force derived classes to use it
    protected abstract AccountType getAccountType();

    protected abstract boolean isOverdrawn(double accountBalance);

}

