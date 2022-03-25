package com.bridgelabz.addressbookday28;

import java.util.List;


public class AddressBookService {

    private List<AddressBookData> addressBookList;
    public enum IOService {DB_IO}
    private static AddressBookDBService addressBookDBService;

    public AddressBookService()
    {
        addressBookDBService = AddressBookDBService.getInstance();
    }
    public List<AddressBookData> readAddressBookData(IOService ioService)
    {
        if (ioService.equals(IOService.DB_IO)) {
            this.addressBookList = addressBookDBService.readDate();
        }
        return addressBookList;
    }

    public void updateRecord(String name, String phoneNumber) throws AddressBookException
    {
        int result = addressBookDBService.updateAddressBookRecord(name, phoneNumber);
        if (result==0)return;
        AddressBookData  addressBookData=this.getAddressBookData(name);
        if (addressBookData!=null) addressBookData.phone=phoneNumber;
    }

    private AddressBookData getAddressBookData(String name)
    {
        return this.addressBookList.stream()
                .filter(addressBookData -> addressBookData.fname.equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean checkRecordSyncWithDB(String name)
    {
        List<AddressBookData> addressBookData= addressBookDBService.getAddressBookData(name);
        return addressBookData.get(0).equals(getAddressBookData(name));
    }
public static void main(String[] args) throws AddressBookException {
	AddressBookService a = new AddressBookService();
	a.updateRecord("Rahul", "456376543");
}


}
