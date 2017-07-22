import Wrapper from '../app/wrapper';
import { expect } from 'chai';

describe('Wrapper', () => {
    let wrapper: Wrapper;

    beforeEach(() => {
        wrapper = new Wrapper();
    });

    describe('wrap()', () => {

        it('should do nothing for empty strings', () => {
            expect(wrapper.wrap('', 10)).to.equal('');
        });

        it('should not wrap when string is smaller than columns', () => {
            expect(wrapper.wrap('hello', 5)).to.equal('hello');
        });

        it('should wrap two words after space', () => {
            expect(wrapper.wrap('hello world', 7)).to.equal('hello\nworld');
        });

    });
});
