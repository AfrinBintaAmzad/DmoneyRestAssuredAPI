package test_runner;

import controller.Transaction;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

import java.io.IOException;

public class TransactionTestRunner extends Setup {
    Transaction transaction;

    @Test(priority = 1, description = "Deposit money from system with invalid credentials")
    public void depositMoneyFromAgentWithInvalidCreds() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositMoneyFromSystemToAgent();
        Assert.assertTrue(transaction.getMessage().contains("Account does not exist"));

    }

    @Test(priority = 2, description = "Deposit money from system with valid credentials")
    public void depositeMoneyFromAgentWithValidCreds() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositMoneyWithSystem();
        Assert.assertTrue(transaction.getMessage().contains("Deposit successful"));

    }

    @Test(priority = 3, description = "Deposit money from system with minimum <10 BDT")
    public void depositMoneyWithInsufficientAmount() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositMoneyWithInsufficientAmount();
        Assert.assertTrue(transaction.getMessage().contains("Minimum deposit amount 10 tk and maximum deposit amount 10000 tk"));
    }

    @Test(priority = 4,description = "Deposit money from system with maximum >10 BDT")
    public void depositMoneyWithSufficientAmount() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositMoneyWithSufficientAmount();
        Assert.assertTrue(transaction.getMessage().contains("Deposit successful"));

    }

    @Test(priority = 5,description = "Deposit money from customer to invalid credentials")
    public void depositMoneyFromCustomerToInvalidAgent() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositMoneyFromCustomerToInvalidAgent();
        Assert.assertTrue(transaction.getMessage().contains("Account does not exist"));

    }
    @Test(priority = 6, description = "Deposit money from invalid agent")
    public void depositMoneyAgentToCustomerWithInvalidPhoneNumber() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositMoneyAgentToCustomerWithInvalidPhoneNumber();
        Assert.assertTrue(transaction.getMessage().contains("Account does not exist"));
    }

    @Test(priority = 7, description = "  Deposit 2000 tk by valid agent to valid customer ")
    public void depositMoneyFromAgentToCustomer() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositMoneyFromAgentToCustomer();
        Assert.assertTrue(transaction.getMessage().contains("Deposit successful"));
    }

    @Test(priority = 8, description = "Deposit money from agent to invalid customer")
    public void depositMoneyFromAgentToInvalidCustomer() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositMoneyFromAgentToInvalidCustomer();
        Assert.assertTrue(transaction.getMessage().contains("Account does not exist"));
    }

    @Test(priority = 9, description = "Check customer balance with invalid credentials")
    public void checkCustomerBalanceWithInValidCredentials() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.checkCustomerBalanceWithInValidCredentials();
        Assert.assertTrue(transaction.getMessage().contains("User not found"));
    }

    @Test(priority = 10, description = "Check customer balance with valid credentials")
    public void checkCustomerBalanceWithValidCredentials() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.checkCustomerBalanceWithValidCredentials();
        Assert.assertTrue(transaction.getMessage().contains("User balance"));
    }

    @Test(priority = 11, description = "Check statement with invalid transaction Id")
    public void checkStatementWithInvalidTransactionId() throws IOException {
        transaction = new Transaction();
        transaction.checkStatementWithInvalidTransactionId();
        Assert.assertTrue(transaction.getMessage().contains("Transaction not found"));
    }

    @Test(priority = 12, description = "Check statement with valid transaction Id")

    public void checkStatementWithValidTransactionId()  throws IOException {
        transaction = new Transaction();
        transaction.checkStatementWithValidTransactionId() ;
        Assert.assertTrue(transaction.getMessage().contains("Transaction list"));
    }

    @Test(priority = 13, description = "Withdraw money by customer to invalid agent phone number")
    public void withdrawMoneyFromInvalidAgent() throws IOException {
        transaction = new Transaction();
        transaction.withdrawMoneyFromInvalidAgent();
        Assert.assertTrue(transaction.getMessage().contains("Account does not exist"));
    }

    @Test(priority = 14, description = "Withdraw money by customer to valid agent phone number")
    public void withdrawMoneyFromValidAgent() throws IOException {
        transaction = new Transaction();
        transaction.withdrawMoneyFromValidAgent();
        Assert.assertTrue(transaction.getMessage().contains("Withdraw successful"));
    }

    @Test(priority = 15, description = "Withdraw money by customer with insufficient amount and withdraw atleast 10BDT")
    public void withdrawMoneyWithInsufficientBalance() throws IOException {
        transaction = new Transaction();
        transaction.withdrawMoneyWithInsufficientBalance();
        Assert.assertTrue(transaction.getMessage().contains("Minimum withdraw amount 10 tk"));
    }

    @Test(priority = 16, description = "Withdraw money by customer with sufficient balance")
    public void withdrawMoneyWithSufficientBalance()  throws IOException {
        transaction = new Transaction();
        transaction.withdrawMoneyWithSufficientBalance() ;
        Assert.assertTrue(transaction.getMessage().contains("Withdraw successful"));
    }

    @Test(priority = 17, description = "Send money customer to agent number")
    public void sendMoneyFromCustomerToAgent() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyFromCustomerToAgent();
        Assert.assertTrue(transaction.getMessage().contains("From/To account should not be an agent account"));
    }

    @Test(priority = 18, description = "Send money customer to another customer with invalid phone number")
    public void sendMoneyCustomerToCustomerWithInvalidCreds() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyCustomerToCustomerWithInvalidCreds();
        Assert.assertTrue(transaction.getMessage().contains("From/To Account does not exist"));
    }

    @Test(priority = 19, description = "Send money customer to another customer with valid phone number")
    public void sendMoneyCustomerToCustomerWithvalidCredentials() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyCustomerToCustomerWithvalidCredentials();
        Assert.assertTrue(transaction.getMessage().contains("Send money successful"));
    }

    @Test(priority = 20, description = "Send money to another customer with invalid amount")
    public void sendMoneyCustomerToCustomerWithInvalidAmount() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyCustomerToCustomerWithInvalidAmount();
        Assert.assertTrue(transaction.getMessage().contains("Minimum amount 10 tk"));
    }

    @Test(priority = 21, description = "Send money to another customer ")
    public void sendMoneyCustomerToCustomerWithvalidAmount() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyCustomerToCustomerWithvalidAmount();
        Assert.assertTrue(transaction.getMessage().contains("Send money successful"));
    }

    @Test(priority = 22, description = "Check customer statement with invalid customer phoneNumber")
    public void checkCustomerStatementWithInvalidPhoneNumber() throws IOException {
        transaction = new Transaction();
        transaction.checkCustomerStatementWithInvalidPhoneNumber();
        Assert.assertTrue(transaction.getMessage().contains("User not found"));
    }

    @Test(priority = 23, description = "Check customer statement with valid customer phoneNumber")
    public void checkCustomerStatementWithValidPhoneNumber() throws IOException {
        transaction = new Transaction();
        transaction.checkCustomerStatementWithValidPhoneNumber();
        Assert.assertTrue(transaction.getMessage().contains("Transaction list"));
    }

}
