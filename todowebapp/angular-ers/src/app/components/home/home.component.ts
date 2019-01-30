import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {environment} from "../../../environments/environment";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  userNavs: Array<{title: string}>;

  constructor(private authService: AuthService) {}

  ngOnInit() {
    // if (this.authService.hasRoles(['Manager'])) {
    //   this.userNavs = environment.managerNav;
    // } else {
    //   this.userNavs = environment.employeeNav;
    // }
  }
}
