import { TestBed } from '@angular/core/testing';

import { MovieStorageService } from './movie-storage.service';

describe('MovieStorageService', () => {
  let service: MovieStorageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovieStorageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
