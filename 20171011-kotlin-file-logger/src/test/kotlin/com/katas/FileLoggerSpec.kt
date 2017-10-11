package com.katas

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

object FileLoggerSpec : Spek({

    describe("File Logger") {

        it("should append message to end of file") {
            val fileWriter = mock(FileWriter::class.java)
            val logger = FileLogger(fileWriter)
            val message = "A message"

            logger.log(message)

            verify(fileWriter).appendText("log.txt", message)
        }

    }

})