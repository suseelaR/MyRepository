import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  showText = true;
  fruits = ['Apple', 'Banana', 'Mango', 'Orange'];
  isHighlight = true;
}
