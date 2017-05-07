using NUnit.Framework;
using Rhino.Mocks;
using System;
namespace filelogger
{
    [TestFixture()]
    public class FileLoggerTest
    {
        IFileWriter fileWriterMock;
        ITimeProvider timeProviderStub;
        FileLogger fileLogger;

        [SetUp]
        public void SetUp()
        {
            fileWriterMock = MockRepository.GenerateMock<IFileWriter>();
            timeProviderStub = MockRepository.GenerateStub<ITimeProvider>();
            fileLogger = new FileLogger(fileWriterMock, timeProviderStub);
        }

        [Test]
        public void Log_should_write_message_to_new_file_using_current_date_for_its_name()
        {
            String fileName = "log20170120.txt";
            String message = "New message";
            DateTime fakeDate = new DateTime(2017, 01, 20);
            timeProviderStub.Stub(tp => tp.Now()).Return(fakeDate);

            fileLogger.Log(message);

            fileWriterMock.AssertWasCalled(fw => fw.Write(fileName, message));
        }

        [Test]
        public void Log_should_append_message_to_file_when_it_already_exists()
        {
            String fileName = "log20170120.txt";
            String message = "New message";
            DateTime fakeDate = new DateTime(2017, 01, 20);
            timeProviderStub.Stub(tp => tp.Now()).Return(fakeDate);
            fileWriterMock.Stub(fw => fw.Exists(fileName)).Return(true);

            fileLogger.Log(message);

            fileWriterMock.AssertWasNotCalled(fw => fw.Write(fileName, message));
            fileWriterMock.AssertWasCalled(fw => fw.Append(fileName, message));
        }
    }
}
