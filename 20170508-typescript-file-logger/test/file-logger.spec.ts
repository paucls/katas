import FileLogger from '../app/file-logger';
import FileSystem from '../app/file-system';

import {expect} from 'chai';
import * as sinon from 'sinon';

describe('FileLogger', () => {

    const message = 'A message';
    let fileSystemStub: any;

    beforeEach(function () {
        fileSystemStub = sinon.createStubInstance(FileSystem.prototype.constructor);
    });

    describe('log()', () => {

        it('should append message to log.txt file', () => {
            fileSystemStub.exists.returns(true);
            const fileLogger = new FileLogger(fileSystemStub);

            fileLogger.log(message);

            expect(fileSystemStub.append.calledWith('log.txt', message)).to.be.true;
            expect(fileSystemStub.write.called).to.be.false;
        });

        it('should write message to a new log.txt file if it does not exist yet', () => {
            fileSystemStub.exists.returns(false);
            const fileLogger = new FileLogger(fileSystemStub);

            fileLogger.log(message);

            expect(fileSystemStub.append.called).to.be.false;
            expect(fileSystemStub.write.calledWith('log.txt', message)).to.be.true;
        });

    });

});
