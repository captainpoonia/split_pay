import { Component, OnInit } from '@angular/core';
import { GroupsService } from '../services/groups.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { GroupMember } from '../model/groupMember';
import { UsersService } from '../services/users.service';
import { AuthService } from '../services/auth.service';
import { tempUser } from '../model/tempUser';
@Component({
  selector: 'app-addmember',
  templateUrl: './addmember.component.html',
  styleUrls: ['./addmember.component.css']
})
export class AddmemberComponent {

  // userForm: FormGroup;
  members: any;
  userId: number;
  groupId: any;
  users: any[];
  user: User;
  successFlag: boolean;
  errorFlag: boolean;
  temp:any[];
  tempuser : tempUser;
  // temp:[];
  constructor(public auth: AuthService, private fb: FormBuilder, public http: HttpClient, public groupService: GroupsService, public userService: UsersService) {
    this.members = [];
    this.userId = 0;
    this.users = [];
    this.user = new User();
    this.user.userId = 0;
    this.user.password = '';
    this.user.userMobile = '';
    this.temp=[];
    this.successFlag = false;
    this.errorFlag = false;
    this.tempuser= new tempUser();
    this.groupService.getNewGroupId().then(e => this.groupId = e);
    console.log(this.groupId);
    this.http.get<any[]>('http://localhost:8080/show/members/'+ this.groupId ).subscribe((res) => {
      this.users = res;
    });

  }
  ngOnInit(): void {
  }

  addMemberSubmit(addMemberForm: any) {
    this.successFlag = false;
    this.errorFlag = false;
    console.log(this.groupId);
    this.user.userId=this.groupId;
   this.users.push([this.user.username,this.user.userEmail]);
    this.auth.addMember(this.user).subscribe(
      (res) => {
        console.log(res);
        if (res) {
          this.user = new User();
          this.user.userId=this.groupId;

          addMemberForm.form.markAsPristine();
          this.auth.currentUser = res;
          this.successFlag = true;
        } else {
          this.errorFlag = true;
        }
      },
      (error) => {
        this.errorFlag = true;
      }
    );
  }
  // public async addMembers(): Promise<void> {
  //   this.members.push(this.userForm.value);
  //   this.userId = await this.userService.getUserId(this.members[this.members.length - 1].username, this.members[this.members.length - 1].userEmail).toPromise();
  //   console.log(this.userId);

  //   this.groupService.addNewUser(this.groupId, this.userId);

  //   this.userForm.reset();
  // }

  public deleteMember(index: number) {
     this.tempuser.groupId=this.groupId;
     this.tempuser.username=this.users[index][0];
     this.tempuser.userEmail=this.users[index][1];
    this.groupService.removeUser( this.tempuser);
    this.users.splice(index, 1);
  }


}




