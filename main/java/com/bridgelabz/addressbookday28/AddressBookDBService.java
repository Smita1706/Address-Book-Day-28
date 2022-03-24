package com.bridgelabz.addressbookday28;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
	public Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	private static AddressBookDBService addressBookDBService;

	public AddressBookDBService() {
	}

	public static AddressBookDBService getInstance() {
		if (addressBookDBService == null) {
			addressBookDBService = new AddressBookDBService();
		}
		return addressBookDBService;
	}

	private Connection getConnection() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/addressbook_services";
        String userName="root";
        String password="Smita@123";
        Connection connection;
        connection = DriverManager.getConnection(dbURL,userName,password);
        System.out.println(" Database connection is successfull");
        return connection;
    }

	public static void main(String[] args) throws SQLException {
		AddressBookDBService a =new AddressBookDBService();
		a.getConnection();
	}
	public List<AddressBookData> readDate() {
		String query = "SELECT * from address_book";
		return this.getAddressBookDataUsingDB(query);
	}

	private List<AddressBookData> getAddressBookDataUsingDB(String query) {
		List<AddressBookData> addressBookList = new ArrayList<>();
		try (Connection connection = this.getConnection()) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			addressBookList = this.getAddressBookData(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookList;
	}

	private List<AddressBookData> getAddressBookData(ResultSet resultSet) {
		List<AddressBookData> addressBookList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				String typeId = resultSet.getString("type");
				String firstName = resultSet.getString("fname");
				String lastName = resultSet.getString("lname");
				String address = resultSet.getString("address");
				String phoneNumber = resultSet.getString("phone");
				String email = resultSet.getString("email");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zip = resultSet.getString("zip");
				addressBookList.add(new AddressBookData(typeId, firstName, lastName,address, phoneNumber, email, city, state, zip));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookList;
	}

}
