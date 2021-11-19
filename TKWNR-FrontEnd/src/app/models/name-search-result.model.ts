export class NameSearchResult {
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
    public get imageURI(): URL {
        return this._imageURI;
    }
    public set imageURI(value: URL) {
        this._imageURI = value;
    }
    public get nameId(): string {
        return this._nameId;
    }
    public set nameId(value: string) {
        this._nameId = value;
    }
    constructor(
        private _nameId: string,
        private _imageURI: URL,
        private _title: string,
        private _description: string
    ){}
}