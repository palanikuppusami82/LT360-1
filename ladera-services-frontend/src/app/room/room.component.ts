import { Component, OnInit } from '@angular/core';
import { Room } from '../room';
import { NavigationExtras, Router} from '@angular/router';
import { RoombookingserviceService } from '../services/roombookingservice.service';


@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {
  
 rooms: Room[] = [
   ];
   dataSource : any[] = [];
  

  constructor(private router: Router,private roombookingserviceService:RoombookingserviceService) { }

  ngOnInit(): void {
    this.roombookingserviceService.getAllRooms().subscribe( (data:any) =>{
      this.rooms=data;
    
     });
  }

  public gotoRoomBooking(id: string) {
    this.router.navigate(['/roombooking'],{ queryParams: { roomId: id}});
  }
}
