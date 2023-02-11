export class SeatInfo{
       
    public  seatNumber:Map<string, string>;
    public  wingCode:String;
    public  wingName:String;
    public  wingCapacity:number;
    public  unAssignedEmployeeMap:Map<string, string>;

 
    constructor(wingCode : String, wingName : String, wingCapacity:number, seatNumber:Map<string, string>, unAssignedEmployeeMap:Map<string, string>){
         this.wingCode = wingCode;
         this.wingName = wingName;
         this.wingCapacity = wingCapacity;
         this.seatNumber = seatNumber;
         this.unAssignedEmployeeMap =unAssignedEmployeeMap;
     }
}
