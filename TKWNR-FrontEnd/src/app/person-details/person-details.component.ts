import { PersonDetail } from './../models/star-detail.model';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { SearchService } from '../search.service';

@Component({
  selector: 'person-details',
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css']
})
export class PersonDetailsComponent implements OnInit {

  id: number = 0;
  person: PersonDetail = new PersonDetail();

  constructor(private route: ActivatedRoute, private router: Router, private searchService: SearchService) { }

  ngOnInit(){
    this.id = this.route.snapshot.params['id'];

    this.searchService.getPersonDetail(this.id)
      .subscribe(data => {
        this.person = data;
      }, error => console.log(error))

  }

}
