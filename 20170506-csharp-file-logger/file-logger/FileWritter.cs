using System;
using System.IO;
namespace filelogger
{
    public class FileWritter : IFileWriter
    {
        public bool Exists(String path)
        {
            return File.Exists(path);
        }

        public void Write(String path, String text)
        {
            File.WriteAllText(path, text);
        }

        public void Append(String path, String text)
        {
            File.AppendAllText(path, text);
        }
    }
}
