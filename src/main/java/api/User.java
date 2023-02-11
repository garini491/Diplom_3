package api;

import Pages.RegPage;

public class User {
    private String email = RegPage.getEmail();
    private String password = RegPage.getPassword();
    private String name = RegPage.getName();

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
