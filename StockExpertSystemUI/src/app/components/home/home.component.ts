import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { StockService } from 'src/app/core/services/stock.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  ticker: string = '';
  algorithm: string = '';
  // values: boolean[];

  constructor(public stockService: StockService) { }

  ngOnInit(): void {

  }

  onSubmit() {
    this.stockService.getSuggestion(this.ticker, this.algorithm);
  }

}
