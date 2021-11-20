export class TitleSearchResult {
    // public get description(): string {
    //     return this.description;
    // }
    // public set description(value: string) {
    //     this.description = value;
    // }
    // public get title(): string {
    //     return this.title;
    // }
    // public set title(value: string) {
    //     this.title = value;
    // }
    // public get imageURI(): string {
    //     return this.imageURI;
    // }
    // public set imageURI(value: string) {
    //     this.imageURI = value;
    // }
    // public get titleId(): string {
    //     return this.titleId;
    // }
    // public set titleId(value: string) {
    //     this.titleId = value;
    // }
    constructor(
        public titleId: string,
        public imageURI: string,
        public title: string,
        public description: string
    ){}
}