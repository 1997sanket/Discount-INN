import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { StaffLoginService } from './service/staff-login.service';

@Injectable({
  providedIn: 'root'
})
export class StaffLoginGuard implements CanActivate {


  constructor(private authService: StaffLoginService, private router: Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    /*if (localStorage.getItem('token') == 'root') return true;

    else return false; */

    if (this.authService.isTokenPresent()) return true;

    else return false;
  }

}





