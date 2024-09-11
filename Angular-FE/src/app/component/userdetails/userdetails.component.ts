import {Component, OnInit} from '@angular/core';
import {UserService} from "../../service/user.service";
import {User} from "../../Interface/user.interface";
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrl: './userdetails.component.css'
})
export class UserdetailsComponent implements OnInit{
  user: User[];
  title = 'User';
  constructor(
    private route: ActivatedRoute,
    private userService : UserService
  ){}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if(id) {
        this.userService.getUser(+id).subscribe(
          (result: User[]) => {
            this.user = result;
          }
        );
      }
    });
  }
}
