package com.bridgelabz.addressbookday28;

import java.util.Objects;

public class AddressBookData {
	public String typeId;
    public String fname;
    public String lname;
    public String address;
    public String phone;
    public String email;
    public String city;
    public String state;
    public String zip;

    public AddressBookData( String typeId, String firstName, String address,String lastName, String phoneNumber, String email, String city, String state, String zip) {
        this.typeId = typeId;
        this.fname = firstName;
        this.lname = lastName;
        this.address = address;
        this.phone = phoneNumber;
        this.email = email;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressBookData that)) return false;
        return  Objects.equals(typeId,that.typeId )&&
                fname.equals(that.fname) &&
                lname.equals(that.lname) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(zip, that.zip);
    }

    @Override
    public String toString() {
        return "AddressBookData{" + "typeId=" + typeId + ", firstName='" + fname + '\'' + ", lastName='"
                + lname + '\'' + ", phoneNumber='" + phone + '\'' + ", email='" + email + '\'' + ", city='"
                + city + '\'' + ", state='" + state + '\'' + ", zip='" + zip + '\'' + '}';
    }
}
