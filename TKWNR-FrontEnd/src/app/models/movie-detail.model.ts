import { Similar } from './Similar.model';
import { Star } from './star.model';
import { CreatorDirector } from './creator-director.model';
export class MovieDetail {
    title:string;
    imageURI:string;
    releaseDate:string;
    runtime:string;
    plot:string;
    creatorDirectorList:CreatorDirector[];
    starList:Star[];
    genres:string;
    companies:string;
    contentRating:string;
    imdbRating:string;
    imdbRatingVotes:number;
    similarList:Similar[];

    constructor(){
        this.title = "";
        this.imageURI = "";
        this.releaseDate = "";
        this.runtime = "";
        this.plot = "";
        this.creatorDirectorList = [];
        this.starList = [];
        this.genres = "";
        this.companies = "";
        this.contentRating = "";
        this.imdbRating = "";
        this.imdbRatingVotes = 0;
        this.similarList = [];
    }

}