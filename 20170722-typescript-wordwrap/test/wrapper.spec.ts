import Wrapper from '../app/wrapper';
import { expect } from 'chai';

describe('Wrapper', () => {
    let wrapper: Wrapper;

    beforeEach(() => {
        wrapper = new Wrapper();
    });

    it('should not wrap an empty string', () => {
        expect(wrapper.wrap('', 10)).to.equal('');
    });

    it('should not wrap a single word string shorter than columns', () => {
        expect(wrapper.wrap('hello', 10)).to.equal('hello');
    });

    it('should not wrap a multiple word string shorter than columns', () => {
        expect(wrapper.wrap('hi all!', 8)).to.equal('hi all!');
    });

    it('should wrap two words after first space', () => {
        expect(wrapper.wrap('hello world', 8)).to.equal('hello\nworld');
    });

    it('should wrap a single word string longer than columns', () => {
        expect(wrapper.wrap('hello', 3)).to.equal('hel\nlo');
    });
});
