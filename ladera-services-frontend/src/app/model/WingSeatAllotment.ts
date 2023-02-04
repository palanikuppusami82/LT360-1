export class WingSeatAllotment {
       
       public  wingCode:String;
       public  wingName:String;
       public  wingCapacity:number;
    
       constructor(wingCode : String, wingName : String, wingCapacity:number){
            this.wingCode = wingCode;
            this.wingName = wingName;
            this.wingCapacity = wingCapacity;
        }
}
