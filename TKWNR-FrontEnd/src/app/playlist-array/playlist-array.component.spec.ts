import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaylistArrayComponent } from './playlist-array.component';

describe('PlaylistArrayComponent', () => {
  let component: PlaylistArrayComponent;
  let fixture: ComponentFixture<PlaylistArrayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlaylistArrayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaylistArrayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
