import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { GasStation } from 'src/app/model/gas-station.model';
import { GeocodingService } from 'src/app/services/geocoding.service';
import { StationService } from 'src/app/services/station.service';

@Component({
  selector: 'app-user-location-test',
  templateUrl: './user-location-test.component.html',
  styleUrls: ['./user-location-test.component.css']
})
export class UserLocationTestComponent implements OnInit {

  private _longitude: any;
  private _latitude: any;
  private _stations: GasStation[] = [];
  private _distance: number = 5;
  private _searchAddress: String;
  private _foundAddress: String;


  constructor(
    private stationService: StationService, private geocodingService: GeocodingService) { }

  ngOnInit(): void {
    // this.getLocationFromBrowser();
  }

  public getLocationFromAddress(): void{
    this.geocodingService.findLocalisation("hello");
  }

  public getLocationFromBrowser(): void{
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position)=>{
          this.longitude = position.coords.longitude;
          this.latitude = position.coords.latitude;
          //this.callApi(longitude, latitude);
        });
    } else {
       console.log("No support for geolocation")
    }
  }

  public rechercher(): void {
    this.stationService.findByLocalisationAndDistance(this.latitude, this.longitude, this.distance).subscribe((res) => {
      this.stations = res;
    })
  }

  //callApi(Longitude: number, Latitude: number){
    //const url = `https://api-adresse.data.gouv.fr/reverse/?lon=${Longitude}&lat=${Latitude}`
    //Call API
  //}

  public get latitude(): any {
    return this._latitude;
  }
  public set latitude(value: any) {
    this._latitude = value;
  }
  public get longitude(): any {
    return this._longitude;
  }
  public set longitude(value: any) {
    this._longitude = value;
  }
  public get stations(): GasStation[] {
    return this._stations;
  }
  public set stations(value: GasStation[]) {
    this._stations = value;
  }
  public get distance(): number {
    return this._distance;
  }
  public set distance(value: number) {
    this._distance = value;
  }
  public get searchAddress(): String {
    return this._searchAddress;
  }
  public set searchAddress(value: String) {
    this._searchAddress = value;
  }
  public get foundAddress(): String {
    return this._foundAddress;
  }
  public set foundAddress(value: String) {
    this._foundAddress = value;
  }
}
