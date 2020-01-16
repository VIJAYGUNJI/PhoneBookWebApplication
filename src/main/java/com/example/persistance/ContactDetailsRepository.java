package com.example.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetailsEntity, Integer> {

	@Transactional
	@Modifying
	@Query("update ContactDetailsEntity set switches = :sw where contactId = :id")
	public void updateContactDetailsById(String sw,int id);
	
}
