using NUnit.Framework;
using Rhino.Mocks;
using System;
namespace filelogger
{
    [TestFixture()]
    public class FileLoggerTest
    {
        IFileWriter fileWriterMock;
        FileLogger fileLogger;

        [SetUp]
        public void SetUp()
        {
            fileWriterMock = MockRepository.GenerateMock<IFileWriter>();
            fileLogger = new FileLogger(fileWriterMock);
        }

        [Test]
        public void Log_should_write_message_to_file()
        {
            String path = "log.txt";
            String message = "New message";

            fileLogger.Log(message);

            fileWriterMock.AssertWasCalled(fw => fw.Write(path, message));
        }

        [Test]
        public void Log_should_append_message_to_file_when_it_already_exists()
        {
            String path = "log.txt";
            String message = "New message";
            fileWriterMock.Stub(fw => fw.Exists(path)).Return(true);

            fileLogger.Log(message);

            fileWriterMock.AssertWasNotCalled(fw => fw.Write(path, message));
            fileWriterMock.AssertWasCalled(fw => fw.Append(path, message));
        }
    }
}
