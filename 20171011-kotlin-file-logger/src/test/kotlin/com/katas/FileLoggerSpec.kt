package com.katas

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.mockito.Mockito.*

object FileLoggerSpec : Spek({

    describe("File Logger") {
        val message = "A message"
        val fileWriterMock = mock(FileWriter::class.java)
        val dateProviderMock = mock(DateProvider::class.java)
        val logger = FileLogger(fileWriterMock, dateProviderMock)

        it("should append message to end of file when file already exists for the day") {
            `when`(dateProviderMock.currentDate("yyyyMMdd")).thenReturn("20170129")
            `when`(fileWriterMock.exist("log20170129.txt")).thenReturn(true)

            logger.log(message)

            verify(fileWriterMock).appendText("log20170129.txt", message)
        }

        it("should write message to new file when file does not exist yet for the day") {
            `when`(dateProviderMock.currentDate("yyyyMMdd")).thenReturn("20170129")
            `when`(fileWriterMock.exist("log20170129.txt")).thenReturn(false)

            logger.log(message)

            verify(fileWriterMock).writeText("log20170129.txt", message)
        }

    }

})