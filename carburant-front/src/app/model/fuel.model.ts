export class Fuel {

    constructor(
        private _type?: string,
        private _id?: number,
        private _available?: boolean,
        private _price?: number,
        private _lastUpdate?: Date
    ) {}

    public get lastUpdate(): Date {
        return this._lastUpdate;
    }
    public set lastUpdate(value: Date) {
        this._lastUpdate = value;
    }
    public get price(): number {
        return this._price;
    }
    public set price(value: number) {
        this._price = value;
    }
    public get available(): boolean {
        return this._available;
    }
    public set available(value: boolean) {
        this._available = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get type(): string {
        return this._type;
    }
    public set type(value: string) {
        this._type = value;
    }

}
