import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Reimbursement } from '../models/Reimbursement';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  reimbursementsUrl:string = '/todowebapp_war_exploded/reimb';
  reimbursementsLimit = '?_limit=5';

  constructor(private http:HttpClient) { }


  
  // Get Reimbursements
  getReimbursements():Observable<Reimbursement[]> {
    return this.http.get<Reimbursement[]>(`${this.reimbursementsUrl}${this.reimbursementsLimit}`);
  }

  // Approve Completed
  approveCompleted(reimbursement: Reimbursement):Observable<any> {
    const url = `${this.reimbursementsUrl}/${reimbursement.id}`;
    return this.http.put(url, reimbursement, httpOptions);
  }

}
