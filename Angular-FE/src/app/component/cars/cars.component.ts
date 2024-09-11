import {Component, OnInit} from '@angular/core';
import {Car} from "../../Interface/car.interface";
import {CarService} from "../../service/car.service";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrl: './cars.component.css'
})
export class CarsComponent implements OnInit{
  cars: Car[];
  title = 'Car Catalog';

  constructor(private carService : CarService){}

  ngOnInit(): void {
    this.carService.getCars().subscribe(
      (result: Car[])=> {
        this.cars=result;
      }
    )
  }
}
