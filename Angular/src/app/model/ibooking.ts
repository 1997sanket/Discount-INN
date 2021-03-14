export interface IBooking {
    bookingId: number;
    checkIn: string;
    checkOut: string;
    hotelId: number;
    customer: {
        custId: number,
        firstName: string,
        lastName: string,
        email: string,
        address: string,
        mobile: string
    }
}
