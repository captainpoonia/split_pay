package com.split_pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@CrossOrigin(origins="*")
public class AppController {
 
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	GroupsRepository groupsRepository;
	
	@Autowired
	ExpensesRepository expensesRepository;
	
	@Autowired
	ExpenseDetailsRepository expenseDetailsRepository;
	
	@Autowired
	GroupMembersRepository groupMembersRepository;
	
	//signUp
	@PostMapping("/signup")
	public User addUser(@RequestBody User user) {
		return usersRepository.save(user);
	}
	
	//Show all users
	@GetMapping("/users/all")
	public List<User> showUsers(){
		return (List<User>) usersRepository.findAll();
	}
	
	//add member in group(the member who will create group will be added)

	public void addMember1(@RequestBody GroupMember groupMember) {
		System.out.println(groupMember.toString());
		groupMembersRepository.save(groupMember);
		
	}
	
	//Add Member
	@PostMapping("/add/member")
	public GroupMember addMember2(@RequestBody Temp temp) {
		User user;
		user=usersRepository.findByUsernameAndUserEmail(temp.getUsername(),temp.getUserEmail());
		Integer u_id=user.getUserId();
		GroupMember groupMember=new GroupMember(u_id,temp.getG_id());
		return groupMembersRepository.save(groupMember);
		
		//we can keep g_name also in temp then findByG_name g_id and then
		/*
		 * GroupMember groupMember=new GroupMember(u_id,g_id)
		 **/
	}
	//Add group
		@PostMapping("/addgroup")
		public Group addGroup(@RequestBody Group group) {
			 System.out.println(group.toString()); 
			 Group group1;
			 
			 group1= groupsRepository.save(group);
			 Integer id=group1.getG_id();
			 //group1.setG_id(id);
			 System.out.println(group1.getCreated_by());
			 GroupMember groupMember= new GroupMember(group1.getCreated_by(),group1.getG_id());
			 addMember1(groupMember);
			 System.out.println(groupMember.toString());
			 return group1;
		}
	
	//show all groups
	@GetMapping("/groups/all")
	public List<Group> showGroups(){
		return (List<Group>) groupsRepository.findAll();
	}
	
	//Show members of a specific group by g_id
	@GetMapping("/show/members/{g_id}")
	public Object showMembers(@PathVariable int g_id){
		Object o=groupMembersRepository.joinGroupMembersAndUsers(g_id);
		return o;
	}
	
	//show all groups in which user is present
	@GetMapping("/show/usergroups/{userId}")
	public Object showUserGroups(@PathVariable int userId) {
		Object o=groupMembersRepository.joinGroupMembersAndGroups(userId);
		return o;
	}

	// Sign In
	@PostMapping("/signin")
	public User searchUser(@RequestBody User user) {
		return usersRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
	
}
