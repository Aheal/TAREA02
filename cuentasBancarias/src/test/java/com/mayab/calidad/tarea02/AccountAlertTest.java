package com.mayab.calidad.tarea02;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountAlertTest {

    private AlertListener alerta;
    @Mock
    private Account account;
    @Before
    public void setup(){
        alerta = mock(AlertListener.class);
    }
    @Test 
    public void envioAlerta(){
        this.account = new Account("Alex",100,1,alerta);
        account.debit(50);
        verify(alerta).sendAlert("Alex, your account balance is below 100");
    }
}