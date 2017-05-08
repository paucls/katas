import FileLogger from '../app/file-logger';
import FileSystem from '../app/file-system';

import { expect } from 'chai';
import * as sinon from 'sinon';

describe('FileLogger', () => {

    describe('log()', () => {

        it('should append message to log.txt file', () => {
            const message = 'New message';
            const writeSpy = sinon.stub(FileSystem.prototype, 'write');
            const fileLogger = new FileLogger(new FileSystem());

            fileLogger.log(message);

            expect(writeSpy.calledWith('log.txt', message)).to.be.true;
        });

    });

});
