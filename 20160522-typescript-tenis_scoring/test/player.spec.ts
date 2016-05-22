/// <reference path="../typings/chai/chai.d.ts" />
/// <reference path="../typings/mocha/mocha.d.ts" />
import {expect} from 'chai';
import {Player} from '../app/player';

describe('Player', function () {

    it('should start with a score of 0', () => {
        let player = new Player();

        expect(player.getScore()).to.equal(0);
    });

    describe('scores()', function() {
    
        it('should score a 15point the first time', function() {
            let player = new Player();

            player.scores();
    
            expect(player.getScore()).to.equal(15);
        });
    
    });

});