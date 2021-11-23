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

    // constructor(){
    //     this.title = "Léon: The Professional";
    //     this.imageURI = "https://m.media-amazon.com/images/M/MV5BODllNWE0MmEtYjUwZi00ZjY3LThmNmQtZjZlMjI2YTZjYmQ0XkEyXkFqcGdeQXVyNTc1NTQxODI@._V1_Ratio0.6791_AL_.jpg";
    //     this.releaseDate = "1994-09-14";
    //     this.runtime = "1h 50mins";
    //     this.plot = "After her father, step-mother, step-sister and little brother are killed by her father's employers, the 12-year-old daughter of an abject drug dealer manages to take refuge in the apartment of a professional hitman who at her request teaches her the methods of his job so she can take her revenge on the corrupt DEA agent who ruined her life by killing her beloved brother.";
    //     this.creatorDirectorList = [new CreatorDirector("1", "Luc Besson")];
    //     this.starList = [
    //         new Star("1",  new URL("http://www.kinopoisk.ru/im/kadr/1/2/4/kinopoisk.ru-Jean-Reno-1247394.jpg"), "Jean Reno", "Leon"),
    //         new Star("2", new URL("https://cutewallpaper.org/21/gary-oldman-wallpapers/Gary-Oldman-HD-Wallpapers-Celebs-and-movies-in-2019-.jpg"), "Gary Oldman", "Stansfield"),
    //         new Star("3", new URL("https://buzzthisnow.com/wp-content/uploads/2020/10/Natalie-Portman-764x1024.jpg"), "Natalie Portman", "Mathilda")
    //     ];
    //     this.genres = "Action, Crime, Drama, Thriller";
    //     this.companies = "Gaumont, Les Films du Dauphin, Columbia Pictures";
    //     this.contentRating = "R";
    //     this.imdbRating = "8.5";
    //     this.imdbRatingVotes = 1050598;
    //     this.similarList = [
    //         new Similar("1", "Se7en", new URL("https://static1.cbrimages.com/wordpress/wp-content/uploads/2020/07/Seven-1.jpg")),
    //         new Similar("2", "The Green Mile", new URL("https://premieremovieposters.com.au/wp-content/uploads/2020/01/3.47D-scaled.jpg")),
    //         new Similar("3", "American History X", new URL("https://i.imgur.com/y4B45xV.jpg"))
    //     ];
    // }

}