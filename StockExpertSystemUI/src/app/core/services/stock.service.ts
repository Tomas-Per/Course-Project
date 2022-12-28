import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StockService {
  values: string = '';
  private ticker = new BehaviorSubject('');
  currentTicker = this.ticker.asObservable();

  private suggestion = new BehaviorSubject('');
  currentSuggestion = this.suggestion.asObservable();

  constructor(private http: HttpClient) { }

  getSuggestion(ticker: string, algorithm: string) {
    this.values = '';
    this.ticker.next(ticker.toUpperCase());
    this.http.get<boolean[]>(environment.apiUrl + 'stocks/suggestion/' + algorithm + '/' + ticker).subscribe(val => {

      if(val[0]) {
        this.values += 'Buy';
      }
      if(val[1]) {
        this.values += ' Sell';
      }
      if(val[2]) {
        this.values += ' Hold';
      }

      this.suggestion.next(this.values) ;
    });


  }
}
