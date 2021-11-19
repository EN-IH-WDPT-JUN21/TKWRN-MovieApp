export class TitleSearchResult {
    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }
    public get title(): string {
        return this._title;
    }
    public set title(value: string) {
        this._title = value;
    }
    public get imageURI(): string {
        return this._imageURI;
    }
    public set imageURI(value: string) {
        this._imageURI = value;
    }
    public get titleId(): string {
        return this._titleId;
    }
    public set titleId(value: string) {
        this._titleId = value;
    }
    constructor(
        private _titleId: string,
        private _imageURI: string,
        private _title: string,
        private _description: string
    ){}
}