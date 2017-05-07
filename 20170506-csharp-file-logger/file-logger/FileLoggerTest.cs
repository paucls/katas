using NUnit.Framework;
using Rhino.Mocks;
using System;
namespace filelogger
{
    [TestFixture()]
    public class FileLoggerTest
    {
        [Test()]
        public void Log_should_append_message_to_file()
        {
            String message = "New message";
            var fileWriterMock = MockRepository.GenerateMock<IFileWriter>();
            FileLogger fileLogger = new FileLogger(fileWriterMock);

            fileLogger.Log(message);

            fileWriterMock.AssertWasCalled(fw => fw.Write("log.txt", message));
        }
    }
}
