package katas.photos

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object FileSystemImplIntegrationSpec : Spek({

    describe("File System Impl") {

        it("should list files in a directory") {
            val fileSystem = FileSystemImpl()
            val path = "src/test/test-photos"

            val result = fileSystem.listFiles(path)

            assertThat(result).containsExactly(
                    File("$path/photo001.CR2", "photo001", "CR2"),
                    File("$path/photo002.CR2", "photo002", "CR2"),
                    File("$path/photo002.jpg", "photo002", "jpg"),
                    File("$path/photo003.CR2", "photo003", "CR2")
            )
        }
    }

})