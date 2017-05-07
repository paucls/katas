using System;
namespace filelogger
{
    public class FileLogger
    {
        private const String DefaultPath = "log.txt";
        private IFileWriter fileWriter;

        public FileLogger(IFileWriter fileWriter)
        {
            this.fileWriter = fileWriter;
        }

        public void Log(String message)
        {
            if (fileWriter.Exists(DefaultPath))
            {
                fileWriter.Append(DefaultPath, message);
                return;
            }

            fileWriter.Write(DefaultPath, message);
        }
    }
}
