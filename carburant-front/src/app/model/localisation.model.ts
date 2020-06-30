export class Localisation {

  constructor(
    private _id?: number,
    private _adresse?: string,
    private _codePostal?: string,
    private _ville?: string,
    private _pop?: string,
    private _longitude?: number,
    private _latitude?: number
){}

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
