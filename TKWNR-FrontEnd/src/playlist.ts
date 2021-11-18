import { Movie } from "./app/movie";

export class Playlist {
    id!: number;
    name!: string;
    length!: number;
    type!: any;
    userName!: string;
    movies?: Movie[];
  }