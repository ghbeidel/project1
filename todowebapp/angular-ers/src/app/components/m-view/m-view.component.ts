import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../models/Reimbursement';
import { ManagerService } from '../../services/manager.service';

@Component({
  selector: 'app-m-view',
  templateUrl: './m-view.component.html',
  styleUrls: ['./m-view.component.css']
})
export class MViewComponent implements OnInit {
  reimbursements:Reimbursement[];

  constructor(private managerService:ManagerService) { }

  ngOnInit() {
    this.managerService.getReimbursements().subscribe(reimbursements => {
      this.reimbursements = reimbursements;
    });
  }

}
