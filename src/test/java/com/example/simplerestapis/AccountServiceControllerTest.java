package com.example.simplerestapis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.simplerestapis.models.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class AccountServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getProductsList() throws Exception {
        String url = "/accounts";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(200, responseStatus);
        String responseContent = mvcResult.getResponse().getContentAsString();
        Account[] accountslist = super.mapFromJson(responseContent, Account[].class);
        assertTrue(accountslist.length > 0);
    }
    @Test
    public void createProduct() throws Exception {
        String uri = "/accounts";
        Account account = new Account();
        account.setId("312");
        account.setName("Smith Carter");
        account.setAccountNumber(123452);
        account.setAccountType("Checking");
        String inputJson = super.mapToJson(account);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();


        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(201, responseStatus);
        String responseContent = mvcResult.getResponse().getContentAsString();
        assertEquals(responseContent, "Account is created successfully");
    }
    @Test
    public void updateProduct() throws Exception {
        String url = "/accounts/213";
        Account account = new Account();
        account.setName("Harry Porter");
        String inputJson = super.mapToJson(account);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(200, responseStatus);
        String responseContent = mvcResult.getResponse().getContentAsString();
        assertEquals(responseContent, "Account is updated successfully");
    }
    @Test
    public void deleteProduct() throws Exception {
        String url = "/accounts/213";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();

        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(200, responseStatus);
        String responseContent = mvcResult.getResponse().getContentAsString();
        assertEquals(responseContent, "Account is deleted successfully");
    }
}
