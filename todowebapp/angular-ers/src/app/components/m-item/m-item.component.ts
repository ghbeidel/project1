import { Component, OnInit, Input } from '@angular/core';
import { ManagerService } from '../../services/manager.service';

import { Reimbursement } from 'src/app/models/reimbursement';

@Component({
  selector: 'app-m-item',
  templateUrl: './m-item.component.html',
  styleUrls: ['./m-item.component.css']
})
export class MItemComponent implements OnInit {
  @Input() reimbursement: Reimbursement;

  constructor(private managerService:ManagerService) { }

  ngOnInit() {
  }

  // Set Dynamic Classes
  setClasses() {
    let classes = {
      reimbursement: true
    }

    return classes;
  }

  approve(reimbursement) {
    console.log('Approved!');
    this.managerService.approveCompleted(reimbursement).subscribe(reimbursement =>
      console.log(reimbursement));
  }

  deny(reimbursement) {
    console.log('Denied!');
  }

  pending(reimbursement) {
    console.log('Pending...');
  }

  onDelete(reimbursement) {
    console.log('delete');
  }

}
