import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  public showNavBar: boolean = true;
  public name: string = '';
  @ViewChild("sidenav") sidenav !: MatSidenav;
  public isUserLoggedIn!: boolean;

  constructor(private router: Router,
              private readonly _keycloakService: KeycloakService) {
    this._keycloakService.isLoggedIn().then(
      (isLoggedIn: boolean) => this.isUserLoggedIn = isLoggedIn
    );
  }

  ngOnInit(): void {
  }

  public navigateToDashboard(): void {
      this.router.navigate(['/dashboard'])
  }

  // @ts-ignore
  public isHR(): boolean {
    //return this.storage.get('role') == AccountTypeEnum.HR;
  }

  // @ts-ignore
  public isReviewer(): boolean {
   // return this.storage.get('role') == AccountTypeEnum.REVIEWER;
  }

  public isLoggedIn(): boolean {
    return this.isUserLoggedIn;
  }

  public logUserOut(): void {
    this._keycloakService.logout();
    this.sidenav.close();

  }

}
