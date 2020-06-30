import { Fuel } from './fuel.model';
import { Localisation } from './localisation.model';

export class GasStation {


    constructor(
        private _id?: number,
        private _localisation?: Localisation,
        private _automate247?: boolean,
        private _fuel?: Fuel[]
    ){}

    public get fuel(): Fuel[] {
        return this._fuel;
    }
    public set fuel(value: Fuel[]) {
        this._fuel = value;
    }
    public get automate247(): boolean {
        return this._automate247;
    }
    public set automate247(value: boolean) {
        this._automate247 = value;
    }
    public get localisation(): Localisation {
      return this._localisation;
    }
    public set localisation(value: Localisation) {
      this._localisation = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

}
