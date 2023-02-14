package api;

import pages.RegPage;

public class User {
    private final String email = RegPage.getEmail();
    private final String password = RegPage.getPassword();
    private final String name = RegPage.getName();

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
