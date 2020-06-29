import { Fuel } from './fuel.model';

export class GasStation {

    constructor(
        private _id?: number,
        private _adresse?: string,
        private _codePostal?: string,
        private _ville?: string,
        private _pop?: string,
        private _longitude?: number,
        private _latitude?: number,
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
    public get latitude(): number {
        return this._latitude;
    }
    public set latitude(value: number) {
        this._latitude = value;
    }
    public get longitude(): number {
        return this._longitude;
    }
    public set longitude(value: number) {
        this._longitude = value;
    }
    public get pop(): string {
        return this._pop;
    }
    public set pop(value: string) {
        this._pop = value;
    }
    public get ville(): string {
        return this._ville;
    }
    public set ville(value: string) {
        this._ville = value;
    }
    public get codePostal(): string {
        return this._codePostal;
    }
    public set codePostal(value: string) {
        this._codePostal = value;
    }
    public get adresse(): string {
        return this._adresse;
    }
    public set adresse(value: string) {
        this._adresse = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

}
