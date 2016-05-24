/// <reference path="../typings/chai/chai.d.ts" />
/// <reference path="../typings/mocha/mocha.d.ts" />
import {expect} from 'chai';
import {Player} from '../app/player';
import {Game} from '../app/game';

describe('Game', function () {

    describe('getWinner()', function () {

        it('should return undefined if there is not winner yet', function () {
            let player1 = new Player();
            let player2 = new Player();
            let game = new Game(player1, player2);

            expect(game.getWinner()).to.be.undefined;
        });

    });

});