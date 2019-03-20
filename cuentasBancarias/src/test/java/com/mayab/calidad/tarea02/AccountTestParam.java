package com.mayab.calidad.tarea02;

import java.lang.reflect.Array;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.lang.*;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;

/**
 *
 * @author aleja
 */
@RunWith(Parameterized.class) 

public class AccountTestParam {
    Account account;
    AlertListener alert;
    private int balance, zone, expectedBalance, expectedZone;  
    private String name, expectedName;

    @Before
    public void setUp() {
        alert = new AlertListener();
    }
    
    @After
    public void tearDown() {
    }
    @Parameters
       public static Iterable data(){
           return Arrays.asList(new Object[][]{
                {"Alex",150,1},{"Roman",250,2},{"Pedro",500,3}
            });
       } 
       
       public AccountTestParam(String name, int balance, int zone){
            this.name = name; 
            this.balance = balance; 
            this.zone = zone;
            this.expectedBalance = this.balance;
            this.expectedZone = this.zone;
            this.expectedName = this.name;
            account = new Account(name,balance,zone, alert);
       }
       
       @Test
        public void balance() {
            System.out.println("[TEST]");
            assertThat(this.account.getBalance(), is(this.expectedBalance)); 
            System.out.println(this.expectedBalance);
        }
        @Test
        public void zone() {
            assertThat(this.account.getZone(), is(this.expectedZone)); 
            System.out.println(this.expectedZone); 
        }
        @Test
        public void holder() {
            assertThat(this.account.getHolder(), is(this.expectedName)); 
            System.out.println(this.expectedName); 
        }
}
