import { ICity } from "./icity";

export class City implements ICity{
    constructor(
        public cityId:number,
        public city:string
    ){}
}
