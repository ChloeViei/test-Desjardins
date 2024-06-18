import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { UsersComponent } from './users.component';
import { UserService } from 'src/app/services/user.service';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { User } from 'src/app/models/user';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientTestingModule } from '@angular/common/http/testing';

@Injectable()
export class MockUserService {
  getUsers(): Observable<User[]> {
    const users: User[] = [
      {
        id: 1,
        name: 'Alice',
        email: 'alice@example.com',
        gender: 'female',
        status: 'active',
      },
      {
        id: 2,
        name: 'Bob',
        email: 'bob@example.com',
        gender: 'male',
        status: 'inactive',
      },
    ];
    return of(users);
  }
}

describe('UsersComponent', () => {
  let component: UsersComponent;
  let fixture: ComponentFixture<UsersComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [
        CommonModule,
        BrowserAnimationsModule,
        HttpClientTestingModule,
        MatTableModule,
        MatSortModule,
        MatPaginatorModule,
      ],
      providers: [{ provide: UserService, useClass: MockUserService }],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should fetch users on ngOnInit', () => {
    component.ngOnInit();
    expect(component.users.data.length).toBe(2);
  });

  it('should sort data when column headers are clicked', () => {
    component.ngOnInit();
    const sortHeaderElement =
      fixture.nativeElement.querySelector('.mat-sort-header');

    expect(component.users.sort?.active).toBe('id');
    expect(component.users.sort?.direction).toBe('asc');

    sortHeaderElement.click();

    fixture.detectChanges();

    expect(component.users.sort?.active).toBe('id');
    expect(component.users.sort?.direction).toBe('desc');
  });
});
