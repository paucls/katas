using System;
namespace filelogger
{
    public class FileLogger
    {
        private const String FileNameTemplate = "log{0}.txt";
        private const String DateFormat = "yyyyMMdd";

        private IFileWriter fileWriter;
        private ITimeProvider timeProvider;

        public FileLogger(IFileWriter fileWriter, ITimeProvider timeProvider)
        {
            this.fileWriter = fileWriter;
            this.timeProvider = timeProvider;
        }

        public void Log(String message)
        {
            String fileName = buildFileName();

            if (fileWriter.Exists(fileName))
            {
                fileWriter.Append(fileName, message);
                return;
            }

            fileWriter.Write(fileName, message);
        }

        String buildFileName()
        {
            String currentDate = timeProvider.Now().ToString(DateFormat);
            return String.Format(FileNameTemplate, currentDate);
        }
    }
}
