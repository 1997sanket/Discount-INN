import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
@Component({
  selector: 'app-floor-plan',
  templateUrl: './floor-plan.component.html',
  styleUrls: ['./floor-plan.component.css']
})
export class FloorPlanComponent implements OnInit, AfterViewInit {
  
  @ViewChild('enlargedImg') eImage:ElementRef;

  ngOnInit(): void {
    
  }

  ngAfterViewInit(): void {
    (<HTMLImageElement>this.eImage.nativeElement).src="http://localhost:4200/assets/images/studio1.png";
  }
  
   preview(event:Event) {
    let loc = (<HTMLImageElement>event.target).src;
    (<HTMLImageElement>this.eImage.nativeElement).src=loc;
   }
   
  
}
