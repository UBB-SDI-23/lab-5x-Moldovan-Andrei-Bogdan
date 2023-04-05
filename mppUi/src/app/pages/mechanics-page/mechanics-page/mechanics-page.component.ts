import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Mechanic } from 'src/app/types/domain-types';
import { MechanicService } from 'src/app/services/mechanic-service.service';
import { Subscription, catchError, of, tap } from 'rxjs';

@Component({
  selector: 'app-mechanics-page',
  templateUrl: './mechanics-page.component.html',
  styleUrls: ['./mechanics-page.component.scss']
})
export class MechanicsPageComponent implements OnInit, OnDestroy {
  mechanicsList!: Array<Mechanic>;
  subscriptions: Subscription = new Subscription();
  @ViewChild('salaryInput') salaryInputDomElement!: ElementRef;

  constructor(protected mechanicsService: MechanicService) {}

  ngOnInit(): void {
    this.subscriptions.add(
      this.mechanicsService.getAllMechanics().subscribe((mechanicData) => {
        this.mechanicsList = mechanicData;
      })
    );
  }

  filterMechanics(): void {
    let salaryFilterValue = this.salaryInputDomElement.nativeElement.value;
    if (salaryFilterValue === '') {
      this.subscriptions.add(
        this.mechanicsService.getAllMechanics().pipe(
          tap((data) => {this.mechanicsList = data}),
          catchError((err) => {return of(err)})
        ).subscribe()
      );
    } else {
      salaryFilterValue = parseInt(salaryFilterValue);
      if (!salaryFilterValue) {
        alert("Please enter a numerical value or nothing to get all");
      } else {
        this.subscriptions.add(
          this.mechanicsService.getFilteredMechanics(salaryFilterValue).pipe(
            tap((data) => {this.mechanicsList = data}),
            catchError((err) => {return of(err)})
          ).subscribe()
        );
      }
    }
  }

  removeMechanic(id: number) {
    this.mechanicsList = Array.from(this.mechanicsList.filter((mechanicData) => {
      return mechanicData.id !== id;
    }));
  }

  sortMechanics() {
    this.mechanicsList.sort((mechanic1, mechanic2) => {
      if (mechanic1.salary > mechanic2.salary) {
        return -1;
      }
      if (mechanic1.salary < mechanic2.salary) {
        return 1;
      }
      return 0;
    });
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }
}
