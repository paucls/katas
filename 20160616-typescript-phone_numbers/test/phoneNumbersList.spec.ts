/// <reference path="../typings/chai/chai.d.ts" />
/// <reference path="../typings/mocha/mocha.d.ts" />
import {expect} from 'chai';
import {PhoneNumberList} from '../app/phoneNumberList';

describe('PhoneNumbersList', () => {

    describe('isConsistent()', () => {

        it('should return true for an empty list', () => {
            let phoneNumberList = new PhoneNumberList([]);

            expect(phoneNumberList.isConsistent()).to.be.true;
        });

        it('should return true for a list with two not clashing numbers', function () {
            let phoneNumberList = new PhoneNumberList(['911', '97 625 992']);

            expect(phoneNumberList.isConsistent()).to.be.true;
        });

        it('should return false for a list with two clashing numbers', function () {
            let phoneNumberList = new PhoneNumberList(['911','91125426']);

            expect(phoneNumberList.isConsistent()).to.be.false;
        })

    });
});
