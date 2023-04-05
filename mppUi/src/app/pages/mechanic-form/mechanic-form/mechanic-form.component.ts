import { Component, ElementRef, OnDestroy, OnInit, ViewChild, ViewChildren } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription, catchError, of, tap } from 'rxjs';
import { MechanicService } from 'src/app/services/mechanic-service.service';
import { Mechanic, MechanicEntityDTO } from 'src/app/types/domain-types';

@Component({
  selector: 'app-mechanic-form',
  templateUrl: './mechanic-form.component.html',
  styleUrls: ['./mechanic-form.component.scss']
})
export class MechanicFormComponent implements OnInit, OnDestroy {
  @ViewChild('firstNameInput') firstNameInputDOM!: ElementRef;
  @ViewChild('secondNameInput') secondNameInputDOM!: ElementRef;
  @ViewChild('brandExpertiseInput') brandExpertiseInputDOM!: ElementRef;
  @ViewChild('dateHiredInput') dateHiredInputDOM!: ElementRef;
  @ViewChild('salaryInput') salaryInputDOM!: ElementRef;
  subscriptions: Subscription = new Subscription();
  mechanic!: Mechanic;
  exists: boolean = false;

  constructor(protected activatedRoute: ActivatedRoute, protected mechanicService: MechanicService) {}

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  ngOnInit(): void {
    this.subscriptions.add(
      this.activatedRoute.paramMap.subscribe((data) => {
        const mechanicID = data.get('id');

        if (mechanicID) {
          this.mechanicService.getMechanicById(parseInt(mechanicID)).subscribe((mechanicData) => {
            this.mechanic = mechanicData;
            this.exists = true;
          })
        }
      })
    );
  }

  submitBtnClick(): void {
    // this.salaryInputDOM.nativeElement.value = 1000;
    // console.log(this.firstNameInputDOM.nativeElement.value);
    // console.log(this.secondNameInputDOM.nativeElement.value);
    // console.log(this.brandExpertiseInputDOM.nativeElement.value);
    // console.log(this.dateHiredInputDOM.nativeElement.value);
    // console.log(this.salaryInputDOM.nativeElement.value);
    const mechanicData: MechanicEntityDTO = {
      firstName: this.firstNameInputDOM.nativeElement.value,
      secondName: this.secondNameInputDOM.nativeElement.value,
      brandExpertise: this.brandExpertiseInputDOM.nativeElement.value,
      dateHired: this.dateHiredInputDOM.nativeElement.value,
      salary: this.salaryInputDOM.nativeElement.value
    }
    if (this.exists) {
      this.subscriptions.add(
        this.mechanicService.updateMechanic(this.mechanic.id, mechanicData).pipe(
          tap((value) => {alert("Mechanic was updated")}),
          catchError((err) => {console.log(err);alert("Error when updating mechanic");return of(err)})
        ).subscribe()
      );
    } else {
      this.subscriptions.add(
        this.mechanicService.addMechanic(mechanicData).pipe(
          tap((value) => {alert("Mechanic was added")}),
          catchError((err) => {console.log(err);alert("Error when adding mechanic");return of(err)})
        ).subscribe()
      )
    }
  }
}
