package com.bridgelabz.addressbookday28;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




public class AddressBookDBService {
	 public Connection connection = null;
	    Statement statement = null;
	    ResultSet resultSet = null;
	    private PreparedStatement addressBookDataStatement;
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
	        String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_services?useSSL=false";
	        String userName = "root";
	        String password = "Smita@123";
	        connection = DriverManager.getConnection(jdbcURL, userName, password);
	        System.out.println(connection + " connection successful");
	        return connection;
	    }

	    public List<AddressBookData> readDate() {
	        String query = "SELECT * from  address_book";
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
	                addressBookList.add(new AddressBookData(typeId, firstName,address, lastName, phoneNumber, email, city, state, zip));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return addressBookList;
	    }

	    private void prepareStatementForAddressBook() {
	        try {
	            Connection connection = this.getConnection();
	            String sql = "SELECT * FROM  address_book WHERE `fname` = ?";
	            addressBookDataStatement = connection.prepareStatement(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public List<AddressBookData> getAddressBookData(String firstName) {
	        List<AddressBookData> addressBookDataList = null;
	        if (this.addressBookDataStatement == null) {
	            this.prepareStatementForAddressBook();
	        }
	        try {
	            addressBookDataStatement.setString(1, firstName);
	            ResultSet resultSet = addressBookDataStatement.executeQuery();
	            addressBookDataList =this.getAddressBookData(resultSet);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return addressBookDataList;
	    }

	    public int updateAddressBookRecord(String name, String phoneNumber) throws AddressBookException {
	        String query = String.format("update  address_book set phone = '%s' where fname= '%s' ;", phoneNumber, name);
	        try (Connection connection = this.getConnection()) {
	            Statement statement = connection.createStatement();
	            return statement.executeUpdate(query);
	        }catch (SQLException e) {
	            throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DatabaseException);
	        }
	    }
}
