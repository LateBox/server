package com.latebox.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.latebox.server.product.Product;
import com.latebox.server.product.ProductController;
import com.latebox.server.product.ProductRepository;
//import org.aspectj.lang.annotation.Before;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

//@ContextConfiguration(locations={"classpath:WEB-INF/application-context.xml"})
//@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(ProductController.class)
public class ProductTest{

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper ;



//    @MockBean(name="productRepository")
    @MockBean
    ProductRepository productRepository;

    @InjectMocks
    ProductController productController;

    Product RECORD_1 = new Product("Shawarma", "This is a lebanese shawarma", "3", "1", "14");
    Product RECORD_2 = new Product("Burrito", "This is a mexican burrito", "4", "2", "7");
    Product RECORD_3 = new Product("Pizza", "This is an italian Pizza slice", "2", "3", "24");
    // ... Test methods TBA

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void getAllProducts_success() throws Exception {
        List<Product> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(productRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }


    @Test
    public void getProductByName_success() throws Exception {
        List<Product> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(productRepository.findByName("Shawarma")).thenReturn((List<Product>) records.get(0));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[1].name", is("Shawarma")));

    }

    @Test
    public void deleteOneProduct_success() throws Exception {
        List<Product> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(productRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }





}
