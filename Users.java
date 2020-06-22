package com.example.sts.ui;

public class Users {
    String usernameE,PasswordE,acctypeE;

    public Users() {
    }

    public Users(String usernameE, String passwordE, String acctypeE) {
        this.usernameE = usernameE;
        PasswordE = passwordE;
        this.acctypeE = acctypeE;
    }

    public String getUsernameE() {
        return usernameE;
    }

    public void setUsernameE(String usernameE) {
        this.usernameE = usernameE;
    }

    public String getPasswordE() {
        return PasswordE;
    }

    public void setPasswordE(String passwordE) {
        PasswordE = passwordE;
    }

    public String getAcctypeE() {
        return acctypeE;
    }

    public void setAcctypeE(String acctypeE) {
        this.acctypeE = acctypeE;
    }
}
