package com.bridgelabz.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, Integer>{

	AddressBookModel findByEmail(String email);
	

}
