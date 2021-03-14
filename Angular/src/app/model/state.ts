import { City } from "./city";
import { IState } from "./istate";

export class State implements IState{
    constructor(
        public stateId:number,
        public state:string,
        public cities:City[]
    ){}
}
