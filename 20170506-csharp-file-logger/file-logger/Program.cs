using System;

namespace filelogger
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Logging to file...");

            IFileWriter fileWriter = new FileWritter();
            FileLogger fileLogger = new FileLogger(fileWriter);

            fileLogger.Log(args[0]);
        }
    }
}
