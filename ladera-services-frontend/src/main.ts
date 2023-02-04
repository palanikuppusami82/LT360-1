import { enableProdMode, importProvidersFrom } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';
import {bootstrapApplication} from '@angular/platform-browser';
import { AssetmanagmentComponent } from './app/admin/assetmanagment/assetmanagment.component';
import { LtdraganddropComponent } from './app/ltdraganddrop/ltdraganddrop.component';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));

bootstrapApplication(AssetmanagmentComponent,{
  providers: [importProvidersFrom(LtdraganddropComponent)]
});