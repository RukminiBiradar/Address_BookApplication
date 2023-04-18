package com.bridgelabz.addressbook.service;

import java.util.List;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;

public interface IAdressBookService {

	String addAddressBook(AddressBookDTO addressBookDTO);

	List<AddressBookModel> getddressBookData();

	String deleteAddressBook(int id);

	AddressBookModel updateAddressBook(int id, AddressBookDTO addressBookDTO);

	AddressBookModel getEmpData(int id);
	
	

}
