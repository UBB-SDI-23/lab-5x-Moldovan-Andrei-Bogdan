import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Mechanic, MechanicEntityDTO, MechanicWithCars } from '../types/domain-types';
import { ServerError } from '../types/error-types';

@Injectable({
  providedIn: 'root'
})
export class MechanicService {

  // private mechanicsURL = 'http://localhost:8080/mechanics';
  private mechanicsURL = 'http://mppmainsrv-env.eba-jghymzcb.eu-north-1.elasticbeanstalk.com/mechanics';

  constructor(protected httpClient: HttpClient) {
  }

  getAllMechanics(): Observable<Array<Mechanic>> {
    return this.httpClient.get<Array<Mechanic>>(this.mechanicsURL);
  }

  getMechanicById(id: number): Observable<MechanicWithCars> {
    return this.httpClient.get<MechanicWithCars>(`${this.mechanicsURL}/${id}`);
  }

  updateMechanic(id: number, updatedData: MechanicEntityDTO) {
    return this.httpClient.put<String>(`${this.mechanicsURL}/${id}`, updatedData);
  }

  addMechanic(mechanicData: MechanicEntityDTO) {
    return this.httpClient.post<String>(`${this.mechanicsURL}`, mechanicData);
  }

  deleteMechanic(id: number): Observable<boolean> {
    return this.httpClient.delete<boolean>(`${this.mechanicsURL}/${id}`);
  }

  getFilteredMechanics(salaryFilterValue: number): Observable<Array<Mechanic>> {
    return this.httpClient.get<Array<Mechanic>>(`${this.mechanicsURL}/filter/${salaryFilterValue}`);
  }
}
