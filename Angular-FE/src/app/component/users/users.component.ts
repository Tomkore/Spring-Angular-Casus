import {Component, OnInit} from '@angular/core';
import {UserService} from "../../service/user.service";
import {User} from "../../Interface/user.interface";
import {Router} from "@angular/router";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent implements OnInit{
  users: User[];
  title="Users";
  constructor(
    private userService : UserService,
    private router : Router
  ) {}

  ngOnInit(): void {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
      this.userService.getUsers().subscribe(
        (result: User[]) => {
          this.users = result
        }
      );
  }
}
