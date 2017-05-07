using System;
namespace filelogger
{
    public interface IFileWriter
    {
        bool Exist(String path);

        void Write(String path, String message);

        void Append(String path, String message);
    }
}
