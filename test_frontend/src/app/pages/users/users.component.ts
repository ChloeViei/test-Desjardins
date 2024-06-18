import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserService } from 'src/app/services/user.service';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatSortModule, MatPaginatorModule],
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
})
export class UsersComponent {
  displayedColumns: string[] = ['id', 'name', 'email', 'gender', 'status'];
  users = new MatTableDataSource<User>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort: MatSort = new MatSort();

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.fetchUsers();
  }

  fetchUsers(): void {
    this.userService.getUsers().subscribe((data: any) => {
      this.users = new MatTableDataSource(data);
      this.users.sort = this.sort;
      this.users.sortingDataAccessor = (
        item: any,
        property: string
      ): string | number => {
        return typeof item[property] === 'string'
          ? item[property].toLowerCase()
          : item[property];
      };

      this.sort.active = this.displayedColumns[0];
      this.sort.direction = 'asc';

      this.users.paginator = this.paginator;
    });
  }
}
