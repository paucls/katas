import FileLogger from '../app/file-logger';
import FileSystem from '../app/file-system';

import {expect} from 'chai';
import * as sinon from 'sinon';

describe('FileLogger', () => {

    const message = 'A message';
    const now = new Date('2017-01-30');

    let clock;
    let fileSystemStub;

    beforeEach(function () {
        clock = sinon.useFakeTimers(now.getTime());
        fileSystemStub = sinon.createStubInstance(FileSystem.prototype.constructor);
    });

    afterEach(() => {
        clock.restore();
    });

    describe('log()', () => {

        it('should append message to log file', () => {
            fileSystemStub.exists.returns(true);
            const fileLogger = new FileLogger(fileSystemStub);

            fileLogger.log(message);

            expect(fileSystemStub.append.calledWith('log20170130.txt', message)).to.be.true;
            expect(fileSystemStub.write.called).to.be.false;
        });

        it('should write message to a new log.txt file if it does not exist yet', () => {
            fileSystemStub.exists.returns(false);
            const fileLogger = new FileLogger(fileSystemStub);

            fileLogger.log(message);

            expect(fileSystemStub.append.called).to.be.false;
            expect(fileSystemStub.write.calledWith('log20170130.txt', message)).to.be.true;
        });

    });

});
