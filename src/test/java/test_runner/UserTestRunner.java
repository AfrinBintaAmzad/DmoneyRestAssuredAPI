package test_runner;

import controller.User;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

import java.io.IOException;

public class UserTestRunner extends Setup {
    User user;

    @Test(priority = 1, description = "Do login with invalid credential")
    public void doLoginWithInvalidCredentials() throws IOException, ConfigurationException {
        user = new User();
        user.callLoginAPIWithInvalidCredentials();
        Assert.assertTrue(user.getMessage().contains("User not found"));
    }

    @Test(priority = 2, description = "Do login with valid credential")
    public void doLoginWithValidCredentials() throws IOException, ConfigurationException {
        user = new User();
        user.callLoginAPIWithValidCredentials();
        Assert.assertTrue(user.getMessage().contains("Login successfully"));
    }


    @Test(priority = 3, description = "Create user with valid information")
    public void createNewUser() throws IOException, ConfigurationException {
        user = new User();
        user.createUser();
        Assert.assertTrue(user.getMessage().contains("User created"));
    }


    @Test(priority = 4, description = "Create Agent with valid information")
    public void createNewAgent() throws IOException, ConfigurationException {
        user = new User();
        user.createAgent();
        Assert.assertTrue(user.getMessage().contains("User created"));
    }

    @Test(priority = 5)
    public void searchUserByInvalidPhoneNumber() throws IOException, ConfigurationException {
        user = new User();
        user.searchUserByInvalidPhonenumber();
        Assert.assertTrue(user.getMessage().contains("User not found"));
    }

    @Test(priority = 6)
    public void searchUserByValidPhoneNumber() throws IOException, ConfigurationException {
        user = new User();
        user.searchUserByValidPhonenumber();
        Assert.assertTrue(user.getMessage().contains("User found"));
    }

    @Test(priority = 7)
    public void searchAgentByInvalidPhoneNumber() throws IOException, ConfigurationException {
        user = new User();
        user.searchAgentByInvalidPhonenumber();
        Assert.assertTrue(user.getMessage().contains("User not found"));
    }

    @Test(priority = 8)
    public void searchAgentByValidPhoneNumber() throws IOException, ConfigurationException {
        user = new User();
        user.searchAgentByValidPhonenumber();
        Assert.assertTrue(user.getMessage().contains("User found"));
    }

}
