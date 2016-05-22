/// <reference path="../typings/chai/chai.d.ts" />
/// <reference path="../typings/mocha/mocha.d.ts" />
import {expect} from 'chai';
import {Player} from '../app/player';

describe('Player', function () {

    let player:Player;

    beforeEach(function () {
        player = new Player();
    });

    it('should begin with a 0 points', function () {
        expect(player.getWonPoints()).to.equal(0);
    });

    describe('scores()', function () {

        it('should score a 15 point the first success', function () {
            player.scores();

            expect(player.getWonPoints()).to.equal(15);
        });

        it('should score a 30 point the second success', function () {
            player.scores();
            player.scores();

            expect(player.getWonPoints()).to.equal(30);
        });

        it('should score a 40 point the third success', function () {
            player.scores();
            player.scores();
            player.scores();

            expect(player.getWonPoints()).to.equal(40);
        });

    });

});