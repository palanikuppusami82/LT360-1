export class AssetInfoDeatils{
       
    public  assetName:string;
    public  assetType:String;
    public  assetStatus:String;
    public  assetTag:String;

 
    constructor(assetName : string, assetType : string, assetStatus:string,assetTag:string){
         this.assetName = assetName;
         this.assetType = assetType;
         this.assetStatus = assetStatus;
         this.assetTag = assetTag;
     }
}
