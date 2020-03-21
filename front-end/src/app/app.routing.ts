import { Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {HomeComponent} from './components/home/home.component';
import {RegisterComponent} from './components/register/register.component';
import {ProfileComponent} from './components/profile/profile.component';
import {UrlPermission} from './urlPermission/url.permissions';
import { LogoutComponent } from './components/logout/logout.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { MyCoursesComponent } from './components/my-courses/my-courses.component';
import { CoursesComponent } from './components/courses/courses.component';


const appRoutes: Routes = [
  //{ path: '', component: LoginComponent },
  { path: '', component: HomeComponent },
  { path: 'profile', component: ProfileComponent , canActivate: [UrlPermission] },
  { path: 'login', component: LoginComponent },
  { path: 'register/:id', component: RegisterComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'not-found', component: NotFoundComponent },
  { path: 'my-courses', component: MyCoursesComponent },
  { path: 'courses', component: CoursesComponent},
  //{ path: 'enroll', component: LoginComponent },
  { path: 'enroll', component: RegisterComponent },
  // otherwise redirect to profile
  { path: '**', redirectTo: '/not-found' }
];

export const routing = RouterModule.forRoot(appRoutes);
