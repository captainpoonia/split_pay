package com.split_pay;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GroupMembersRepository extends CrudRepository<GroupMember, Integer> {
	@Query(nativeQuery = true, value ="SELECT u.username,u.user_email,g.g_id FROM group_member g join users u on g.user_id=u.user_id where g.g_id=?")
	Object[][] joinGroupMembersAndUsers(int g_id);
	
	@Query(nativeQuery =true, value="SELECT gm.g_id,g.g_name,gm.user_id FROM group_member gm join groups g on gm.g_id=g.g_id WHERE gm.user_id=?")
	Object[][] joinGroupMembersAndGroups(int userId);
}
12345678
