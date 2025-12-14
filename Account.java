package coe318.lab4;

/**
 *
 * @author Samuil Halachev
 * @studentID 501315102
 */
public class Account 
{
    private String name;
    private int number;
    private double balance;
    
    /**
     * Constructs a new Account with the specified owner name, account number,
     * and initial balance.
     * @param name the owner's name
     * @param number the account number
     * @param initialBalance the initial balance
     */
    public Account(String name, int number, double initialBalance) 
    {
        this.name = name;
        this.number = number;
        this.balance = initialBalance;
    }
    
    /**
     * @return the owner's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }
    
    /**
     * @return the account number
     */
    public int getNumber()
    {
        return number;
    }
    
    /**
     * Deposits the specified amount to the account if amount is positive;
     * otherwise false.
     * @param amount the amount to deposit
     * @return true if successful
     */
    public boolean deposit(double amount)
    {
        if(amount <= 0)
        {
            return false;
        }
        else
        {
            balance += amount;
            return true;
        } 
    }
    
    /**
     * Withdraws the specified amount from the account if amount is positive
     * and sufficient funds are available; otherwise false.
     * @param amount the amount to withdraw
     * @return true if successful
     */
    public boolean withdraw(double amount)
    {
        if(amount <= 0 || amount > balance)
        {
            return false;
        }
        else
        {
            balance -= amount;
            return true;
        } 
    }
    

    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "(" + getName() + ", " + getNumber() + ", " +
                String.format("$%.2f", getBalance()) + ")";
    }
}