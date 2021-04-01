public class Application
{
    public static void main(String[] args)
    {
        checkingAccount();
        savingsAccount();
    }

    private static void checkingAccount()
    {
        CheckingAccount checking = new CheckingAccount("1234", "Jesus Mendoza", 12000.00);
        System.out.println(checking.getAccountInformation());
        System.out.println(checking.deposit(150.00));
        System.out.println(checking.withdrawal(200.00));
    }

    private static void savingsAccount()
    {
        SavingsAccount savings = new SavingsAccount("5678", "Tommy Campbell", 900.00);
        System.out.println(savings.getAccountInformation());
        System.out.println(savings.withdrawal(1000.00));
        System.out.println(savings.withdrawal(800.00));
    }
}