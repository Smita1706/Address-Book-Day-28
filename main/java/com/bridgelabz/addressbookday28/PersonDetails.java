package com.bridgelabz.addressbookday28;

public class PersonDetails {
	private String FirstName;
	private String LastName;
	private String Address;
	private String City;
	private String State;
	private int Zip;
	private long PhoneNo;
	private String Email;

	public PersonDetails(String first, String last, String add, String city, String state,
			int zip, long phone, String email) {
		this.FirstName = first;
		this.LastName = last;
		this.Address = add;
		this.City = city;
		this.State = state;
		this.Zip = zip;
		this.PhoneNo = phone;
		this.Email = email;
	}
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getCity() {
		return City;
	}
	
	public void setCity(String city) {
		this.City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		this.State = state;
	}

	public int getZip() {
		return Zip;
	}

	public void setZip(int zip) {
		this.Zip = zip;
	}

	public long getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.PhoneNo = phoneNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}


	@Override
	public String toString() {
		return	"\n First name : " + FirstName + 
				"\n Last name : " + LastName +
				"\n Address : " + Address +
				"\n City : " + City +
				"\n State : " + State +
				"\n Zip code : " + Zip +
				"\n Phone number : " + PhoneNo +
				"\n Email : " + Email ;
	}

	public static void main(String[] args) {
		PersonDetails a = new PersonDetails("riya","jadhav","hadapsar","pune","maharashtra",423345,1234567654,"riya@gmail.com") ;
		a.toString();
	}
}
