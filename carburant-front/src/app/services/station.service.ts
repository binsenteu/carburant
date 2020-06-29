import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { GasStation } from '../model/gas-station.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class StationService {
  private URL: string = "http://localhost:8080/carburant/rest";
  private headers: HttpHeaders;
  private options: object;

  constructor(private httpClient: HttpClient) {}

  public findById(id: number): Observable<GasStation> {
    return this.httpClient.get<GasStation>(`${this.URL}/gas_station/${id}`);
  }


}
