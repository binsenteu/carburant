import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { GasStation } from '../model/gas-station.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class StationService {
  private URL: string = "http://localhost:8080/carburant/rest/gas_station";
  private headers: HttpHeaders;
  private options: object;

  constructor(private httpClient: HttpClient) {}

  public findById(id: number): Observable<GasStation> {
    return this.httpClient.get<GasStation>(`${this.URL}/${id}`);
  }

  public findByZip(zip: string): Observable<Array<GasStation>> {
    return this.httpClient.get<Array<GasStation>>(`${this.URL}/zip/${zip}`);
  }

  public findByLocalisationAndDistance(
    latitude: number,
    longitude: number,
    distance: number
  ): Observable<Array<GasStation>> {
    let params = new HttpParams()
    .set('latitude', latitude.toString())
    .set('longitude', longitude.toString())
    .set('distance', distance.toString());


    return this.httpClient.get<Array<GasStation>>(`${this.URL}/distance`, { params: params });
  }

}
