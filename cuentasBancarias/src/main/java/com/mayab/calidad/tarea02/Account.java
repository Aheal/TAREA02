package com.mayab.calidad.tarea02;

public class Account {
    
    int balance, zone;
    String name;
    AlertListener alerts;

    public Account(String name, int initialBalance, int zone, AlertListener alerts){
        this.name = name;
        this.balance = initialBalance;
        this.alerts = alerts;
        this.zone = zone;
    }
    
    public int getBalance() {
        return this.balance;
    }
    
    public String getHolder(){
        return this.name;
    }

    public int getZone(){
        return this.zone;
    }

    public void debit(int balance) {
        this.balance -= balance;
        if(this.balance < 100){
            this.alerts.sendAlert(this.name+", your account balance is below 100");
        }
    }

    void credit(int balance) {
        this.balance += balance;
    }
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
    
}