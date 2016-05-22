const A_LOVE_POINT = 0;
const A_30_POINT = 30;
const A_40_POINT = 40;

export class Player {

    private points:number = A_LOVE_POINT;

    constructor() {
    }

    getWonPoints():number {
        return this.points;
    }

    scores() {
        if (this.points === A_30_POINT) {
            this.points = A_40_POINT;
            return;
        }

        this.points += 15;
    }
}