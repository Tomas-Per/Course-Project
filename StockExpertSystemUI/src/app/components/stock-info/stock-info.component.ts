import { Component, OnInit } from '@angular/core';
import { StockService } from 'src/app/core/services/stock.service';

@Component({
  selector: 'app-stock-info',
  templateUrl: './stock-info.component.html',
  styleUrls: ['./stock-info.component.scss']
})
export class StockInfoComponent implements OnInit {

  ticker: string = '';
  values: string = '';

  constructor(private stockService: StockService) { }

  ngOnInit(): void {
    this.stockService.currentTicker.subscribe(ticker => this.ticker = ticker);
    this.stockService.currentSuggestion.subscribe(values => this.values = values);
  }

}
