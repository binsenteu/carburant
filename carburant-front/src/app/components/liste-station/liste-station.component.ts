import { Component, OnInit, Input } from '@angular/core';
import { Fuel } from 'src/app/model/fuel.model';
import { GasStation } from 'src/app/model/gas-station.model';

@Component({
  selector: 'app-liste-station',
  templateUrl: './liste-station.component.html',
  styleUrls: ['./liste-station.component.css'],
})
export class ListeStationComponent implements OnInit {
  @Input() private _stations: GasStation[];
  private _order = 'desc';

  constructor() {
  }

  ngOnInit(): void {}

  public sort(colName) {
    if (this.order == 'desc') {
      this.stations.sort(function (a, b) {
        if (a.localisation[colName] > b.localisation[colName]) {
          return 1;
        } else if (a.localisation[colName] < b.localisation[colName]) {
          return -1;
        } else {
          return 0;
        }
      });
      // this.stations.sort((a, b) => a.localisation[colName] > b.localisation[colName] ? 1 : a.localisation[colName] < b.localisation[colName] ? -1 : 0);
      // this.stations.sort((a, b) => a.localisation.codePostal > b.localisation.codePostal ? 1 : a.localisation.codePostal < b.localisation.codePostal ? -1 : 0);
      this.order = 'asc';
    } else {
      this.stations.sort((a, b) =>
        a.localisation[colName] > b.localisation[colName]
          ? -1
          : a.localisation[colName] < b.localisation[colName]
          ? 1
          : 0
      );
      this.order = 'desc';
    }
  }

  public sortFuel(valuePath, fuelType) {
    //TODO : refactor getValue function
    if (this.order == 'desc') {
      this.order = 'asc';
      let path = valuePath.split('.');
      return this.stations.sort((a, b) => {
        return this.getValue(b, path, fuelType) - this.getValue(a, path, fuelType);
      });
    } else {
      this.order = 'desc';
      let path = valuePath.split('.');
      return this.stations.sort((a, b) => {
        return this.getValue(a, path, fuelType) - this.getValue(b, path, fuelType);
      });

    }
  }

  public getValue(obj, path, fuelType) {
    let price = 0;
    if (this.order == "asc"){
      price = 0;
    } else {
      price = 10000
    }
    path.forEach(function (path) {
      obj = obj[path];
      if (Array.isArray(obj)) {
        obj.forEach(function (obj) {
          if (obj.type === fuelType) {
            price = obj.price;
          }
        });
      }
    });
    return price;
  }

  public get stations(): GasStation[] {
    return this._stations;
  }
  public set stations(value: GasStation[]) {
    this._stations = value;
  }
  public get order() {
    return this._order;
  }
  public set order(value) {
    this._order = value;
  }
}
