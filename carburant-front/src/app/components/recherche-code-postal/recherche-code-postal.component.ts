import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StationService } from 'src/app/services/station.service';
import { GasStation } from 'src/app/model/gas-station.model';

@Component({
  selector: 'app-recherche-code-postal',
  templateUrl: './recherche-code-postal.component.html',
  styleUrls: ['./recherche-code-postal.component.css']
})
export class RechercheCodePostalComponent implements OnInit {

  private _zipCode: string = '';
  private _stations: GasStation[] = [];



  constructor(
    private fb: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private stationService: StationService,
    private router: Router) { }

  ngOnInit(): void {
  }

  public rechercher(){
    this.stationService.findByZip(this.zipCode).subscribe((res) => {
      this.stations = res;
    })
  }

  public get zipCode(): string {
    return this._zipCode;
  }
  public set zipCode(value: string) {
    this._zipCode = value;
  }

  public get stations(): GasStation[] {
    return this._stations;
  }
  public set stations(value: GasStation[]) {
    this._stations = value;
  }

}
