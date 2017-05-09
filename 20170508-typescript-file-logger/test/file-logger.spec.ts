import FileLogger from '../app/file-logger';
import FileSystem from '../app/file-system';

import { expect } from 'chai';
import * as sinon from 'sinon';

describe('FileLogger', () => {

    let sandbox = sinon.sandbox.create();

    afterEach(function () {
        sandbox.restore();
    });

    describe('log()', () => {

        it('should append message to log.txt file', () => {
            const message = 'New message';
            const appendSpy = sandbox.stub(FileSystem.prototype, 'append');
            const fileLogger = new FileLogger(new FileSystem());
            sandbox.stub(FileSystem.prototype, 'exists').returns(true);

            fileLogger.log(message);

            expect(appendSpy.calledWith('log.txt', message)).to.be.true;
        });

        it('should write message to a new log.txt file if it does not exist yet', () => {
            const message = 'New message';
            const writeSpy = sandbox.stub(FileSystem.prototype, 'write');
            const fileLogger = new FileLogger(new FileSystem());
            sandbox.stub(FileSystem.prototype, 'exists').returns(false);

            fileLogger.log(message);

            expect(writeSpy.calledWith('log.txt', message)).to.be.true;
        });

    });

});
