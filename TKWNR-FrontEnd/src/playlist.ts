import { MovieDetail } from './app/models/movie-detail.model';


export class Playlist {
    id!: number;
    name!: string;
    length!: number;
    type!: any;
    userName!: string;
    movies?: MovieDetail[];
  }