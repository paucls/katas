package com.katas

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.mockito.Mockito.*

object FileLoggerSpec : Spek({

    describe("File Logger") {
        val message = "A message"
        val fileWriter = mock(FileWriter::class.java)
        val logger = FileLogger(fileWriter)

        it("should append message to end of file when file already exists") {
            `when`(fileWriter.exist("log.txt")).thenReturn(true)

            logger.log(message)

            verify(fileWriter).appendText("log.txt", message)
        }

        it("should write message to new file when file does not exist yet") {
            `when`(fileWriter.exist("log.txt")).thenReturn(false)

            logger.log(message)

            verify(fileWriter).writeText("log.txt", message)
        }
    }

})