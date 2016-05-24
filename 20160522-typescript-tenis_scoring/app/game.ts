import {Player} from './player';

export class Game {
    private player1:Player;
    private player2:Player;

    constructor(player1:Player, player2:Player) {
        this.player1 = player1;
        this.player2 = player2;
    }

    getWinner():Player {
        return;
    }
}