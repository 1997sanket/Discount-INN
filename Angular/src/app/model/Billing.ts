export class Billing {

    constructor(
        public id: number,
        public firstName: string,

        public lastName: string,
        public email: string,
        public mobile: string,
        public hotelName: string,
        public roomType: number,
        public bookingId: number,
        public rentPerDay: number,
        public totalAmount: number,
        public checkIn: Date,
        public checkOut: Date

    ) { }
}