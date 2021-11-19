export class Similar{
    public get titleImage(): URL {
        return this._titleImage;
    }
    public set titleImage(value: URL) {
        this._titleImage = value;
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
        private _titleImage: URL
    ){}
}