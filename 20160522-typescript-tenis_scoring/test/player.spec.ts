/// <reference path="../typings/chai/chai.d.ts" />
/// <reference path="../typings/mocha/mocha.d.ts" />
import {expect} from 'chai';
import {Player} from '../app/player';

describe('Player', function () {

    let player:Player;

    beforeEach(function () {
        player = new Player();
    });

    it('should begin with a score of 0', () => {
        expect(player.getScore()).to.equal(0);
    });

    describe('scores()', function () {

        it('should score a 15point the first success', function () {
            player.scores();

            expect(player.getScore()).to.equal(15);
        });

        it('should score a 30point the second success', function () {
            player.scores();
            player.scores();

            expect(player.getScore()).to.equal(30);
        });

    });

});