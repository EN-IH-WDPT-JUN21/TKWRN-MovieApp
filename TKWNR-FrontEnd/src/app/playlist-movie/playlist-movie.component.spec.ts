import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaylistMovieComponent } from './playlist-movie.component';

describe('PlaylistMovieComponent', () => {
  let component: PlaylistMovieComponent;
  let fixture: ComponentFixture<PlaylistMovieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlaylistMovieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaylistMovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
