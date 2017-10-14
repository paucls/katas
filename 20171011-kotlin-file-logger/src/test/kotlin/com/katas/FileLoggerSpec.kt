package com.katas

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.mockito.Mockito.*
import java.time.LocalDateTime

object FileLoggerSpec : Spek({

    describe("File Logger") {

        val message = "A message"
        val aSaturday = LocalDateTime.of(2017, 10, 14, 0, 0)
        val aSunday = LocalDateTime.of(2017, 10, 15, 0, 0)
        val aMonday = LocalDateTime.of(2017, 10, 16, 0, 0)

        val fileWriterMock = mock(FileWriter::class.java)
        val dateProviderMock = mock(DateProvider::class.java)
        val logger = FileLogger(fileWriterMock, dateProviderMock)

        it("should append message to end of file when file already exists for the day") {
            `when`(dateProviderMock.currentDate()).thenReturn(aMonday)
            `when`(fileWriterMock.exist("log20171016.txt")).thenReturn(true)

            logger.log(message)

            verify(fileWriterMock).appendText("log20171016.txt", message)
        }

        it("should write message to new file when file does not exist yet for the day") {
            `when`(dateProviderMock.currentDate()).thenReturn(aMonday)
            `when`(fileWriterMock.exist("log20171016.txt")).thenReturn(false)

            logger.log(message)

            verify(fileWriterMock).writeText("log20171016.txt", message)
        }

        on("Saturday or Sunday") {

            it("should append message to end of file when weekend.txt file already exists") {
                `when`(dateProviderMock.currentDate()).thenReturn(aSaturday)
                `when`(fileWriterMock.exist("weekend.txt")).thenReturn(true)

                logger.log(message)

                verify(fileWriterMock).appendText("weekend.txt", message)
            }

            it("should write message to new file when weekend.txt file does not exist yet") {
                `when`(dateProviderMock.currentDate()).thenReturn(aSunday)
                `when`(fileWriterMock.exist("weekend.txt")).thenReturn(false)

                logger.log(message)

                verify(fileWriterMock).writeText("weekend.txt", message)
            }

        }

    }

})