/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cyrus
 */

import java.util.Scanner;
public class ATM 
{    
    public static void checkBalance()
    {
        System.out.println("\tYour current balance is: $" + BalanceInquiry.getBalance());
    }
    
    public static void withdrawMoney()
    {
        if(BalanceInquiry.balance==0)
        {
            System.out.println("\tYour current balance is zero dollars.");
            System.out.println("\tYou cannot withdraw.");
            System.out.println("\tDeposit money first.");
        }
        else if(BalanceInquiry.balance<=500)
        {
            System.out.println("\tYou do not have sufficient funds to withdraw.");
            System.out.println("\tPlease check your available balance.");
        }
        else if(Withdraw.withdraw > BalanceInquiry.balance)
        {
            System.out.println("\tThe amount entered is greater than the current balance.");
            System.out.println("\tPlease check the amount entered.");
        }
        else
        {
            BalanceInquiry.balance = BalanceInquiry.balance - Withdraw.withdraw;
            System.out.println("\n\tAmount withdrawn: " + Withdraw.withdraw);
        }
    }
                    
    public static void depositMoney()
    {
        System.out.println("\tDeposited amount: " + Deposit.getDeposit());
    }
    
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        int select = 0;
        int choice = 0;
        
        System.out.println("==================================================");
        System.out.println("\t\tWelcome Saleh!");
        System.out.println("==================================================");
        System.out.println();
        
        do
        {try
                {
            do {
                
                    System.out.println("\n\tPlease Select the Desired Transaction:\n");
                    System.out.println("\tDeposits: \t Press [1]");
                    System.out.println("\tWithdraw: \t Press [2]");
                    System.out.println("\tBalance Inquiry: Press [3]");
                    System.out.println("\tExit: \t\t Press [4]");
                
                    System.out.print("\n\tWhat would you like to do? ");
                    select = read.nextInt();
    
                        if(select>4)
                        {
                            System.out.println("\n\tError: Please select the correct transaction.");
                        }
                        else
                        {
                        switch (select)
                        {
                            case 1:
                                System.out.print("\n\tEnter the amount of money to be deposited: ");
                                Deposit.deposit = read.nextDouble();
                                BalanceInquiry.balance = Deposit.deposit + BalanceInquiry.balance;
                                depositMoney();
                                break;
                                
                            case 2:
                                
                                System.out.print("\n\tTo withdraw, please make sure that you have sufficient funds in your account.");
                               // System.out.println();
                                System.out.print("\n\tEnter amount of money to withdrawn: ");
                                Withdraw.withdraw = read.nextDouble();
                                withdrawMoney();
                                break;
                                
                            case 3:
                                checkBalance();
                                break;
                            
                            default:
                                System.out.print("\n\tTransaction exited.");
                                break;
                                
                        }
                    }                
                           
            }while(select>4);
            
            do {
                try
                {
                    System.out.println("\n\tWould you like to perform another transaction?");
                    System.out.println("\n\tYes: Press [1] \n\tNo: Press [2]");
                    System.out.print("\n\tEnter your choice please: ");
                    choice = read.nextInt();
                
                        if(choice>2)
                        {
                            System.out.print("\n\tPlease select either '1' or '2'.");
                        }
                    }
                    
                    catch(Exception e)
                    {
                        System.out.println("\n\tInput Error: Please enter '1' or '2'.");
                        read = new Scanner(System.in);
                        System.out.println("\tEnter your choice please:");
                        choice = read.nextInt();
                    }
            } while(choice>2);
        }
        catch(Exception e)
                {
                    System.out.println("\tError Input! Please enter a number only.");
                    read = new Scanner(System.in);
                    System.out.println("\tEnter yout choice:");
                    select = read.nextInt();
                }
                
        }while(choice<=1);
        
        System.out.println("\n\tThank you for using this ATM Machine.");
    }
}
