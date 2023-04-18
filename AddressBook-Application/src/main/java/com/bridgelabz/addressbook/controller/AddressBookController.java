package com.bridgelabz.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.Response;
import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.service.IAdressBookService;


@RestController
@RequestMapping("/Addressbook")
public class AddressBookController {

	@Autowired
	IAdressBookService addressBookService;

	@PostMapping("/AddUserData")
	public ResponseEntity<Response> addUserDataInAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
		addressBookService.addAddressBook(addressBookDTO);
		Response response = new Response("User Data Successfully Added In AddressBook", addressBookDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/FetchAllAddressBookData")
	public ResponseEntity<Response> getAllData() {
		List<AddressBookModel> addressBookModelList = addressBookService.getddressBookData();
		Response response = new Response("getting AddressBook Data", addressBookModelList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/DeleteAddressBookById")
	public ResponseEntity<Response> updateAddressBook(@RequestParam int id) {
		addressBookService.deleteAddressBook(id);
		Response response = new Response("Deleted AddressBook by id");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@PutMapping("/Update_AddressBook")
    public ResponseEntity<Response> updateAddressBook(@RequestParam int id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel update = addressBookService.updateAddressBook(id, addressBookDTO);
        Response response = new Response("Address book update successful", update);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@GetMapping("/SearchData")
	public ResponseEntity<Response> getEmpData(@RequestParam int id) {
		 AddressBookModel  addressBookModel = addressBookService.getEmpData(id);
		Response response = new Response("successfuly getting  Data",  addressBookModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}



}
