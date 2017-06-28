import { expect } from 'chai';
import { Item, Shop } from '../app/gilded_rose';

describe('Gilded Rose', function () {

    it('should foo', function () {
        const gilgedRose = new Shop([new Item('foo', 0, 0)]);
        const items = gilgedRose.updateQuality();
        expect(items[0].name).to.equal('fixme');
    });

});