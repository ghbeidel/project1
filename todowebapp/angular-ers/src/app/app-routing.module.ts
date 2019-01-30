import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { EOptionsComponent } from './components/e-options/e-options.component';
import { EViewComponent } from './components/e-view/e-view.component';
import { EAddComponent } from './components/e-add/e-add.component';
import { MViewComponent } from './components/m-view/m-view.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'e-options', component: EOptionsComponent},
  { path: 'e-view', component: EViewComponent},
  { path: 'e-add', component: EAddComponent},
  { path: 'm-view', component: MViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
