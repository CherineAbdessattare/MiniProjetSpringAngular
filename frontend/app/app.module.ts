import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EtudiantsComponent } from './etudiants/etudiants.component';
import { AddEtudiantComponent } from './add-etudiant/add-etudiant.component';
import { FormsModule } from '@angular/forms';
import { UpdateEtudiantComponent } from './update-etudiant/update-etudiant.component';
import { HttpClientModule , HTTP_INTERCEPTORS} from '@angular/common/http';
import { RechercheParDepartementComponent } from './recherche-par-departement/recherche-par-departement.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { SearchFilterPipe } from './search-filter.pipe';
import { ListeDepartementsComponent } from './liste-departements/liste-departements.component';
import { UpdateDepartementComponent } from './update-departement/update-departement.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { TokenInterceptor } from './services/token.interceptor';






@NgModule({
  declarations: [
    AppComponent,
    EtudiantsComponent,
    AddEtudiantComponent,
    UpdateEtudiantComponent,
    RechercheParDepartementComponent,
    RechercheParNomComponent,
    SearchFilterPipe,
    ListeDepartementsComponent,
    UpdateDepartementComponent,
    LoginComponent,
    ForbiddenComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule


  ],
  providers: [{ provide : HTTP_INTERCEPTORS,
    useClass : TokenInterceptor,
    multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
