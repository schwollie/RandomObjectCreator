package dropHere.searchengine.pagerepository;

import dropHere.searchengine.util.Date;

public class Author {

    private String firstName;
    private String lastName;
    private String address;
    private String email;

    private final Date birthday;

    public Author(String firstName, String lastName, String address, String email, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.birthday = birthday;
    }

    //region getters & setters:

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getAge() {
        return getBirthday().yearsUntil(Date.today());
    }

    //endregion

    public boolean equals(Author other) {
        if (this == other) return true;
        if (other == null) return false;

        if (!firstName.equalsIgnoreCase(other.firstName)) return false;
        if (!lastName.equalsIgnoreCase(other.lastName)) return false;
        return birthday.equals(other.birthday);
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

    public String toPrintText() {
        return String.format("%s %s \n%s\n%s\n%s", firstName, lastName, birthday.toString(), address, email);
    }



}

