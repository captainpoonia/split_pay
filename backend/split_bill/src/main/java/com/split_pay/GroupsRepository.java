package com.split_pay;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GroupsRepository extends CrudRepository<Group,Integer>{
	// Join group and users
	
		
}
