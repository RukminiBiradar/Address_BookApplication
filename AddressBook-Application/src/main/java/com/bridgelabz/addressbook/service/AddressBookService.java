package com.bridgelabz.addressbook.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.repository.AddressBookRepository;


import jakarta.mail.internet.AddressException;

@Service
public class AddressBookService implements IAdressBookService {

	@Autowired
	AddressBookRepository addressBookRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public String addAddressBook(AddressBookDTO addressBookDTO) {
		if (addressBookRepo.findByEmail(addressBookDTO.getEmail()) == null) {
			AddressBookModel addressBookModel = modelMapper.map(addressBookDTO, AddressBookModel.class);
			addressBookRepo.save(addressBookModel);
			return "Address Added";

		}
		throw new AddressBookException("This email id is already present");

	}

	@Override
	public List<AddressBookModel> getddressBookData() {
		return addressBookRepo.findAll();
	}

	@Override
	public String deleteAddressBook(int id) {
		if (addressBookRepo.findById(id).isPresent()) {
			addressBookRepo.deleteById(id);
			return "AddressBookdata Deleted";
		}
		throw new AddressBookException("AddressBook not found");

	}

	@Override
	public AddressBookModel updateAddressBook(int id, AddressBookDTO addressBookDTO) {
		AddressBookModel addressModel = modelMapper.map(addressBookDTO, AddressBookModel.class);
		if (addressBookRepo.findById(id).isPresent()) {
			AddressBookModel addressBookModel = addressBookRepo.findById(id).get();
			
			addressModel.setId(id);
			if (addressBookRepo.findByEmail(addressBookDTO.getEmail()) == null) {
				if (addressModel.getName() == null) {
					addressModel.setName(addressBookModel.getName());
				}
				if (addressModel.getAddress() == null) {
					addressModel.setAddress(addressBookModel.getAddress());
				}
				if (addressModel.getEmail() == null) {
					addressModel.setEmail(addressBookModel.getEmail());
				}
				if (addressModel.getCity() == null) {
					addressModel.setCity(addressBookModel.getCity());
				}
				if (addressModel.getState() == null) {
					addressModel.setState(addressBookModel.getState());
				}
				if (addressModel.getZipCode() == 0) {
					addressModel.setZipCode(addressBookModel.getZipCode());
				}
				if (addressModel.getContact() == 0) {
					addressModel.setContact(id);
				}
				return addressBookRepo.save(addressModel);
			}
			throw new AddressBookException("This email_id is already exist");
		}
		throw new AddressBookException("Address Not Found Invalid Id");

	}

	@Override
	public AddressBookModel getEmpData(int id) {
		if (addressBookRepo.findById(id).isPresent()) {
			return addressBookRepo.findById(id).get();
		}
		throw new AddressBookException("Addressbookdata not found " );
	}
		
}
