import { CastMovie } from './cast-movies.model';
import { KnownFor } from './known-for.model';
export class PersonDetail {
    name:string;
    role:string;
    imageURI:string;
    summary:string;
    birthDate:string;
    deathDate:string;
    awards:string;
    knownForList:KnownFor[];
    castMovieList:CastMovie[];

    constructor(){
        this.name = "";
        this.role = "";
        this.imageURI = "";
        this.summary = "";
        this.birthDate = "";
        this.deathDate = "";
        this.awards = "";
        this.knownForList = [];
        this.castMovieList = [];
    }

}