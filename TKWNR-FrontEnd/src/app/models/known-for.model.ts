export class KnownFor {
    public get imageURI(): URL {
        return this._imageURI;
    }
    public set imageURI(value: URL) {
        this._imageURI = value;
    }
    public get role(): string {
        return this._role;
    }
    public set role(value: string) {
        this._role = value;
    }
    public get year(): string {
        return this._year;
    }
    public set year(value: string) {
        this._year = value;
    }
    public get title(): string {
        return this._title;
    }
    public set title(value: string) {
        this._title = value;
    }
    public get titleId(): string {
        return this._titleId;
    }
    public set titleId(value: string) {
        this._titleId = value;
    }
    constructor(
        private _titleId: string,
        private _title: string,
        private _year: string,
        private _role: string,
        private _imageURI: URL
    ){}
}