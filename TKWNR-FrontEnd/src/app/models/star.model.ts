export class Star{
    public get asCharacter(): string {
        return this._asCharacter;
    }
    public set asCharacter(value: string) {
        this._asCharacter = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get imageURI(): URL {
        return this._imageURI;
    }
    public set imageURI(value: URL) {
        this._imageURI = value;
    }
    public get personId(): string {
        return this._personId;
    }
    public set personId(value: string) {
        this._personId = value;
    }
    constructor(
        private _personId: string,
        private _imageURI: URL,
        private _name: string,
        private _asCharacter: string
    ){}
}