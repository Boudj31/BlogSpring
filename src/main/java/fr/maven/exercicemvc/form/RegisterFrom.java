package fr.maven.exercicemvc.form;


public class RegisterFrom {

    private String email;

    private String firstName;

    private String lastName;

    private String city;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegisterFrom(String email, String firstName, String lastName, String city, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.password = password;
    }

    public RegisterFrom(){

    }
}
