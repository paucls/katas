using System;

namespace filelogger
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Logging to file...");

            IFileWriter fileWriter = new FileWritter();
            ITimeProvider timeProvider = new TimeProvider();
            FileLogger fileLogger = new FileLogger(fileWriter, timeProvider);

            fileLogger.Log(args[0]);
        }
    }
}
