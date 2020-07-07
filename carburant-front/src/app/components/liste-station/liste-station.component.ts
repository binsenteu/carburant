import { Component, OnInit, Input } from '@angular/core';
import { GasStation } from 'src/app/model/gas-station.model';

@Component({
  selector: 'app-liste-station',
  templateUrl: './liste-station.component.html',
  styleUrls: ['./liste-station.component.css']
})
export class ListeStationComponent implements OnInit {

  @Input() private _stations: GasStation[];

  constructor() { }

  ngOnInit(): void {
  }

  public get stations(): GasStation[] {
    return this._stations;
  }
  public set stations(value: GasStation[]) {
    this._stations = value;
  }

}
