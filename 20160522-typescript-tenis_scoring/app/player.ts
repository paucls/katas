export class Player {

    private score:number = 0;

    constructor() {
    }

    getScore():number {
        return this.score;
    }

    scores() {
        this.score += 15;
    }
}