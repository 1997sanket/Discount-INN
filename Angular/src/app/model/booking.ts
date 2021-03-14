import { IBooking } from "./ibooking";

export class Booking implements IBooking{
    constructor(
        public bookingId: number,
        public checkIn: string,
        public checkOut: string,
        public hotelId: number,
        public customer: {
        custId: number,
        firstName: string,
        lastName: string,
        email: string,
        address: string,
        mobile: string
    }
    ){}
}
