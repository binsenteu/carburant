import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-location-test',
  templateUrl: './user-location-test.component.html',
  styleUrls: ['./user-location-test.component.css']
})
export class UserLocationTestComponent implements OnInit {

  private _longitude: any;
  private _latitude: any;


  constructor() { }

  ngOnInit(): void {
    this.getLocation();
  }


  getLocation(): void{
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
}
