import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GeocodingService {
  private URL: string = "http://photon.komoot.de/api/?q=allee+le+vau";

  constructor(private httpClient: HttpClient) { }

  public findLocalisation(address: String): void {
    console.log(this.httpClient.get(`${this.URL}`));
  }


}
