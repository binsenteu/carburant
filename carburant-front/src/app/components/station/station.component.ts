import { Component, OnInit } from '@angular/core';
import { GasStation } from 'src/app/model/gas-station.model';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StationService } from 'src/app/services/station.service';

@Component({
  selector: 'app-station',
  templateUrl: './station.component.html',
  styleUrls: ['./station.component.css']
})
export class StationComponent implements OnInit {

  private _station: GasStation;
  private _erreur: boolean = false;
  private _id: number;


  constructor(
    private fb: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private stationService: StationService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.initStation();
  }

  private initStation() {
    this.erreur = false;
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.id = params.id;
        this.stationService.findById(this.id).subscribe((data) => {
          this.station = data;
        })
      }
    })
  }

  public get station(): GasStation {
    return this._station;
  }
  public set station(value: GasStation) {
    this._station = value;
  }

  public get erreur(): boolean {
    return this._erreur;
  }
  public set erreur(value: boolean) {
    this._erreur = value;
  }

  public get id(): number {
    return this._id;
  }
  public set id(value: number) {
    this._id = value;
  }

}
