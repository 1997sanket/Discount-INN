export interface IHotel {
    hotelId: number;
    hotelName: string;
    emailAddress: string;
    contactNo: string;
    city: string;
    state: string;
    pinCode: string;
    distFromCityCenter: number;
    totalRooms: number;
    availableRooms: number;
    roomType: {
        roomTypeId: number,
        roomType: string,
        rent: number
    };
}
