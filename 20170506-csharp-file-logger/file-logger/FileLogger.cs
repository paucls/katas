using System;
namespace filelogger
{
    public class FileLogger
    {
        IFileWriter fileWriter;

        public FileLogger(IFileWriter fileWriter)
        {
            this.fileWriter = fileWriter;   
        }

        public void Log(String message) {
            fileWriter.Write("log.txt", message);
        }
    }
}
