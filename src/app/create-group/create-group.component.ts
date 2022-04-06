import { Component, OnInit } from '@angular/core';
import { Group } from '../model/group';
import { GroupsService } from '../services/groups.service';

import { AuthService } from '../services/auth.service';
@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.css']
})

export class CreateGroupComponent implements OnInit {

  group: Group;
  successFlag: boolean;
  errorFlag: boolean;
  constructor(public auth: AuthService, public groupService : GroupsService) {
    this.group = new Group();
    this.group.created_by=auth.currentUser.userId;
    this.successFlag = false;
    this.errorFlag = false;
  }

  ngOnInit(): void {}

  createGroupSubmit(createGroupForm: any) {
    this.successFlag = false;
    this.errorFlag = false;

    this.auth.createGroup(this.group).subscribe(
      (res) => {
        console.log(res);
        if (res.g_id != 0) {
          this.group = new Group();
          createGroupForm.form.markAsPristine();
          this.successFlag = true;
        } else {
          this.errorFlag = true;
        }
      },
      (error) => {              //similar to catch block, as we did in java
        this.errorFlag = true;
      }
    );
  }
}