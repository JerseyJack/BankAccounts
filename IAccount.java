/**
 * The IAccount class is an interface class for bank accounts.
 * It defines and enforces the use of essential methods for 
 * accounts in an abstract context. 
 * 
 * @author Jack Reynolds
 * @version 1.0
 * @since 02/04/2021
 */
public interface IAccount 
{
    /**
     * Defining the accountType method to be enforced in classes
     * that implement this interface. It should output the 
     * account type as a string.
     * 
     * @return String of the type of account
     */
    public String accountType();

    /**
     * Defining the getAccountInformation method to be enforced in classes
     * that implement this interface. It should output the 
     * account summary.
     * 
     * @return String of all account information
     */
    public String getAccountInformation();

    /**
     * Defining the deposit method to be enforced in classes
     * that implement this interface. It should add money
     * to the account balance and output a deposit receipt.
     * 
     * @param depositAmount
     * @return String of deposit receipt
     */
    public String deposit(double depositAmount);

    /**
     * Defining the withdrawal method to be enforced in classes
     * that implement this interface. It should take money
     * away from the account balance and output a withdrawal
     * receipt.
     * 
     * @param withdrawalAmount
     * @return String of withdrawal receipt
     */
    public String withdrawal(double withdrawalAmount);

    /**
     * Defining the getAccountNumber method to be enforced in classes
     * that implement this interface. It should output the account 
     * number.
     * 
     * @return String account number
     */
    public String getAccountNumber();

    /**
     * Defining the getAccountName method to be enforced in classes
     * that implement this interface. It should output the account
     * holder's name.
     * 
     * @return String account name
     */
    public String getAccountName();

    /**
     * Defining the getAccountBalance method to be enforced in classes
     * that implement this interface. It should output the balance
     * of the account.
     * 
     * @return double account balance
     */
    public double getAccountBalance();

    /**
     * Defining the setAccountBalance method to be enforced in classes
     * that implement this interface. It is it the setter method for 
     * the getAccountBalance.
     * 
     * @param accountBalance
     */
    public void setAccountBalance(double accountBalance);

    /**
     * Defining the getAccountType method to be enforced in classes
     * that implement this interface. It shoud output the account
     * type. 
     * 
     * @return AccountType account type
     */
    public AccountType getAccountType();

}
