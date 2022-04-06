import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { CreateGroupComponent } from './create-group/create-group.component';
import { ExpenseComponent } from './expense/expense.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { GroupsComponent } from './groups/groups.component';
import { AddmemberComponent } from './addmember/addmember.component';
import { SingleGroupComponent } from './single-group/single-group.component';
import { ProfileComponent } from './profile/profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { LogoutComponent } from './logout/logout.component';
import { ReactiveFormsModule } from '@angular/forms';
import { OutgoComponent } from './outgo/outgo.component';
import { InfluxComponent } from './influx/influx.component';
export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },

  {
    path: 'signin',
    component: SignInComponent,
  },
  {
    path: 'signup',
    component: SignUpComponent,
  },
  {
    path: 'creategroup',
    component: CreateGroupComponent,
  },
  {
    path: 'addexpense',
    component: ExpenseComponent,
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
  },
  {
    path: 'groups',
    component: GroupsComponent,
  },
  {
    path: 'addmember',
    component: AddmemberComponent,
  },
  {
    path: 'single-group',
    component: SingleGroupComponent,

  },
  {
    path: 'profile',
    component: ProfileComponent,
  },
  {
    path: 'update_profile',
    component: UpdateProfileComponent,
  },
  {
    path: 'outgo',
    component: OutgoComponent,
  },
  {
    path: 'influx',
    component: InfluxComponent,
  }

];

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    SignInComponent,
    NavbarComponent,
    HomeComponent,
    CreateGroupComponent,
    ExpenseComponent,
    DashboardComponent,
    GroupsComponent,
    AddmemberComponent,
    SingleGroupComponent,
    ProfileComponent,
    UpdateProfileComponent,
    LogoutComponent,
    OutgoComponent,
    InfluxComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
