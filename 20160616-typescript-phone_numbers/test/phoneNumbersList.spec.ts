/// <reference path="../typings/chai/chai.d.ts" />
/// <reference path="../typings/mocha/mocha.d.ts" />
import {expect} from 'chai';
import PhoneNumberList from '../app/phoneNumberList';

describe('PhoneNumbersList', () => {

    describe('isConsistent()', () => {

        it('should return true for an empty list', () => {
            var phoneNumberList = new PhoneNumberList();

            expect(phoneNumberList.isConsistent()).to.be.true;
        });

    });
});
