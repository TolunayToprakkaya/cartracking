package com.car.tracking.system.controllers;

import com.car.tracking.system.controllers.unit.CustomerFactory;
import com.car.tracking.system.factory.JsonFileLoader;
import com.car.tracking.system.models.Customer;
import com.car.tracking.system.services.CustomerService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    private MockMvc mockMvc;

    private Gson gson = new Gson();

    private CustomerFactory customerFactory;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        customerFactory = new CustomerFactory();
    }

    @Test
    public void testNoData() throws Exception {
        List<Customer> customers = Arrays.asList();

        Mockito.when(customerService.findAll()).thenReturn(customers);

        assertThat(customerService.findAll().size(), is(0));
    }

    @Test
    public void testFindAll() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customers").accept(MediaType.ALL);

        List<Customer> customers = customerFactory.getCustomer();

        when(customerService.findAll()).thenReturn(customers);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        JsonElement json = JsonFileLoader.getJsonForFile("example_customers");

        assertEquals(json.toString(), response.getContentAsString());
    }

    @Test
    public void testSave() throws Exception {
        RequestBuilder  requestBuilder = MockMvcRequestBuilders.post("/customers").accept(MediaType.APPLICATION_JSON);

        Customer customer = customerFactory.saveCustomer();

        when(customerService.save(customer)).thenReturn(customer);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        JsonElement jsonElement = JsonFileLoader.getJsonForFile("example_saveCustomers");
        assertEquals(jsonElement.toString(), response.getContentAsString());
    }

}
