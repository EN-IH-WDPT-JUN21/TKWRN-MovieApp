export class Email {
    public get message(): String {
        return this._message;
    }
    public set message(value: String) {
        this._message = value;
    }
    public get name(): String {
        return this._name;
    }
    public set name(value: String) {
        this._name = value;
    }
    public get address(): String {
        return this._address;
    }
    public set address(value: String) {
        this._address = value;
    }

    constructor(private _name: String,
                private _address: String, 
                private _message: String) {

    }

}