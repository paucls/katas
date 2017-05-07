using System;
namespace filelogger
{
    public interface ITimeProvider
    {
        DateTime Now();
    }
}
