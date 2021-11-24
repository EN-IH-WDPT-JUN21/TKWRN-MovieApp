export class CreatorDirector {
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get directorId(): string {
        return this._directorId;
    }
    public set directorId(value: string) {
        this._directorId = value;
    }
    constructor(
        private _directorId: string,
        private _name: string
    ){}
}