import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription, catchError, map, of, tap } from 'rxjs';
import { MechanicService } from 'src/app/services/mechanic-service.service';
import { MechanicWithCars } from 'src/app/types/domain-types';
import { ServerError } from 'src/app/types/error-types';

@Component({
  selector: 'app-mechanic-details-page',
  templateUrl: './mechanic-details-page.component.html',
  styleUrls: ['./mechanic-details-page.component.scss']
})
export class MechanicDetailsPageComponent implements OnInit, OnDestroy {
  mechanicWithCars!: MechanicWithCars;
  displayErrorFlag: boolean = false;
  subcriptions: Subscription = new Subscription();

  constructor(protected mechanicService: MechanicService, protected route:ActivatedRoute, protected router: Router) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((data) => {
      const mechanicID: string | null = data.get('id');

      if (mechanicID !== null) {
        try {
            const convertedID: number = parseInt(mechanicID);
            this.subcriptions.add(this.mechanicService.getMechanicById(convertedID).pipe(
            map((response: MechanicWithCars) => {this.mechanicWithCars = response;return response}),
            catchError((err: ServerError) => {this.displayErrorFlag = true;return of(err)})
          ).subscribe());
        } catch (e) {
          alert("The id given is not a number");
        }
      }
    });
  }

  deleteBtnClick(): void {
    this.subcriptions.add(
      this.mechanicService.deleteMechanic(this.mechanicWithCars.id).pipe(
        tap(() => {this.router.navigateByUrl('/mechanics')}),
        catchError((err) => {alert("Error when removing mechanic");return of(err)})
      ).subscribe()
    );
  }

  ngOnDestroy(): void {
    this.subcriptions.unsubscribe();
  }
}
