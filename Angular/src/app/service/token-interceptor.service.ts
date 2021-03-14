// import { HttpInterceptor } from '@angular/common/http';
// import { Injectable, Injector } from '@angular/core';
// import { StaffLoginService } from './staff-login.service';



// @Injectable({
//   providedIn: 'root'
// })
// //Every request to server will be first passed through this, here we are passing token to the server
// export class TokenInterceptorService implements HttpInterceptor {

//   constructor(private injector: Injector) { }

//   intercept(req, next) {

//     let authService = this.injector.get(StaffLoginService)

//     console.log(authService.getToken());

//     /*
//       Making clone of the request and adding token from Browser's localStorage to the headers.
//       'Bearers xx.yy.zz' is how we pass the token to the server

//     */
//     let tokenizedReq = req.clone({
//       setHeaders: {
//         Authorization: 'Bearer ' + authService.getToken()
//       }
//     })

//     return next.handle(tokenizedReq);
//   }
// }
