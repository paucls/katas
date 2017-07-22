import Wrapper from '../app/wrapper';
import { expect } from 'chai';

describe('Wrapper', () => {
    let wrapper: Wrapper;

    beforeEach(() => {
        wrapper = new Wrapper();
    });

    describe('wrap()', () => {

        it('should do nothing for empty strings', () => {
            const result = wrapper.wrap('', 10);
            expect(result).to.equal('');
        });

    });
});
