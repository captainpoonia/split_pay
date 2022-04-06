import { Component, OnInit } from '@angular/core';
import { ExpenseDetails } from '../model/expense_details';
import { GroupsService } from '../services/groups.service';
import { UsersService } from '../services/users.service';
import { AuthService } from '../services/auth.service';
import { Group } from '../model/group';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.css']
})
export class ExpenseComponent implements OnInit {

  expensedetails: ExpenseDetails;
  successFlag: boolean;
  errorFlag: boolean;


  constructor(public groupsService: GroupsService, public usersService: UsersService, public auth: AuthService,public http: HttpClient) {
      
    this.expensedetails = new ExpenseDetails();
    this.successFlag = false;
    this.errorFlag = false;
      groupsService.getGroups(auth.currentUser.userId);
    usersService.getUsers();
   
  }

  ngOnInit(): void { }

  createExpenseSubmit(createExpenseForm: any) {
    this.successFlag = false;
    this.errorFlag = false;

    this.auth.createExpense(this.expensedetails).subscribe(
      (res) => {
        console.log(res);
        if (res.e_id != 0) {
          this.expensedetails = new ExpenseDetails();
          createExpenseForm.form.markAsPristine();
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