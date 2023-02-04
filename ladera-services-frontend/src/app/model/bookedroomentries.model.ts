export class Bookedroomentries {

       public roomId:String;
       public bookingDate:Date;
       public startTime:String;
       public endTime:String;
       public bookingDiscription:String;
       public bookingEmailId:String;
       public empId:number
    
        constructor(roomId : String, bookedDate : Date, bookedStartTime : String, bookedEndTime : String, bookingDiscription:String,emailId:String,empId:number){
            this.roomId = roomId;
            this.bookingDate = bookedDate;
            this.startTime = bookedStartTime;
            this.endTime = bookedEndTime;
            this.bookingDiscription=bookingDiscription;
            this.bookingEmailId = emailId;
            this.empId = empId;
        }
}
