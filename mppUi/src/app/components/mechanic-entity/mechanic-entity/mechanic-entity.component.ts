import { Component, Input, OnDestroy, Output } from '@angular/core';
import { MechanicService } from 'src/app/services/mechanic-service.service';
import { Mechanic } from 'src/app/types/domain-types';
import { EventEmitter } from '@angular/core';
import { Subscription, catchError, of, tap } from 'rxjs';

@Component({
  selector: 'app-mechanic-entity',
  templateUrl: './mechanic-entity.component.html',
  styleUrls: ['./mechanic-entity.component.scss']
})
export class MechanicEntityComponent implements OnDestroy {
  @Input() mechanic!: Mechanic;
  @Output() removeMechanicEvent: EventEmitter<number> = new EventEmitter();
  subscriptions: Subscription = new Subscription();

  constructor(protected mechanicsService: MechanicService){}
  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  deleteBtnClick(): void {
    // this.mechanicsService.deleteMechanic(this.mechanic.id).subscribe((data) => {
    //   if (data === true) {
    //     this.removeMechanicEvent.emit(this.mechanic.id);
    //   } else {
    //     alert("Error when removing mechanic");
    //   }
    // });

    this.subscriptions.add(
      this.mechanicsService.deleteMechanic(this.mechanic.id).pipe(
        tap(() => {this.removeMechanicEvent.emit(this.mechanic.id);}),
        catchError((err) => {alert("Error when removing mechanic");return of(err);})
      ).subscribe()
    )
  }
}
