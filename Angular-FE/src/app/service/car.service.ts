import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import {Observable, tap} from "rxjs";
import { Car } from "../Interface/car.interface";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class CarService {
  constructor(private http: HttpClient) {}

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>('https://freetestapi.com/api/v1/cars?limit=5').pipe(
      // tap(response => console.log('API Response:', response)),
      map(response => this.processResponse(response))
    );
  }

  private processResponse(response: Car[]): Car[] {
    return response.map(car => ({
      id: car.id,
      make: car.make,
      model: car.model,
      year: car.year,
      color: car.color,           // Include color
      mileage: car.mileage,       // Include mileage
      price: car.price,           // Include price
      fuelType: car.fuelType,
      transmission: car.transmission,
      engine: car.engine,
      horsepower: car.horsepower,
      features: car.features,     // Include features
      owners: car.owners,         // Include owners
      image: car.image
    }));
  }
}
