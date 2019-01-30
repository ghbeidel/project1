import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { EOptionsComponent } from './components/e-options/e-options.component';
import { EViewComponent } from './components/e-view/e-view.component';
import { EAddComponent } from './components/e-add/e-add.component';
import { MViewComponent } from './components/m-view/m-view.component';
import { MItemComponent } from './components/m-item/m-item.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EOptionsComponent,
    EViewComponent,
    EAddComponent,
    MViewComponent,
    MItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
