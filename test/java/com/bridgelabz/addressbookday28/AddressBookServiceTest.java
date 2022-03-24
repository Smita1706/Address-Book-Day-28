package com.bridgelabz.addressbookday28;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import static com.bridgelabz.addressbookday28.AddressBookService.IOService.DB_IO;;
public class AddressBookServiceTest {
	 @Test
	    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchThePeopleCount() {
	        AddressBookService addressBookService = new AddressBookService();
	        List<AddressBookData> addressBookDataList = addressBookService.readAddressBookData(DB_IO);
	        Assert.assertEquals(5,addressBookDataList.size());
	    }
}
