package com.bridgelabz.addressbookday28;

import org.junit.Assert;
import org.junit.Test;
import static com.bridgelabz.addressbookday28.AddressBookService.IOService.DB_IO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;;
public class AddressBookServiceTest {
	 @Test
	    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchThePeopleCount() {
	        AddressBookService addressBookService = new AddressBookService();
	        List<AddressBookData> addressBookDataList = addressBookService.readAddressBookData(DB_IO);
	        assertEquals(5,addressBookDataList.size());
	    }
	    @Test
	    public void givenNewPhoneNumber_ShouldUpdateTheRecorAndSyncWithDataBase() throws AddressBookException {
	        AddressBookService addressBookService = new AddressBookService();
	        addressBookService.readAddressBookData(DB_IO);
	        addressBookService.updateRecord("Rahul", "8147340744");
	        boolean result = addressBookService.checkRecordSyncWithDB("Rahul");
	        assertTrue(result);
	    }
}
