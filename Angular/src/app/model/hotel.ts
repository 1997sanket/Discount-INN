import { IHotel } from "./ihotel";

export class Hotel implements IHotel{
    constructor(
        public hotelId:number,
        public hotelName:string,
        public emailAddress:string,
        public contactNo:string,
        public city:string,
        public state:string,
        public pinCode:string,
        public distFromCityCenter:number,
        public totalRooms: number,
        public availableRooms: number,
        public roomType: {
            roomTypeId: number,
            roomType: string,
            rent: number
        }
    ){}
}
