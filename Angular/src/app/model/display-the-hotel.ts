import {IDisplayTheHotel} from './idisplay-the-hotel';
export class DisplayTheHotel implements IDisplayTheHotel {
  constructor(
    public  hotelId : number,
    public hotelName : string,
    public city : string,
    public state : string,
    public pinCode : string,
    public distFromCityCenter : number,
    public roomType: string,
    public rent : string


   ){

   }
}
