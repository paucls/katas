package katas.photos

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object PhotosServiceSpec : Spek({

    describe("Photos Service") {

        it("should list photos present in multiple formats") {
            val fileSystemStub: FileSystem = mock()
            val service = PhotosService(fileSystemStub)
            whenever(fileSystemStub.listFiles("/path")).thenReturn(setOf(
                    File("/path/photo001.CR2", "photo001", "CR2"),
                    File("/path/photo002.CR2", "photo002", "CR2"),
                    File("/path/photo002.jpg", "photo002", "jpg"),
                    File("/path/photo003.CR2", "photo003", "CR2")
            ))

            val result = service.listDuplicates("/path")

            assertThat(result).containsExactly(
                    "photo002.CR2",
                    "photo002.jpg"
            )
        }

        it("should delete photos in the indicated file format if they are present in multiple formats") {
            val fileSystemMock: FileSystem = mock()
            val service = PhotosService(fileSystemMock)
            whenever(fileSystemMock.listFiles("/path")).thenReturn(setOf(
                    File("/path/photo001.CR2", "photo001", "CR2"),
                    File("/path/photo002.CR2", "photo002", "CR2"),
                    File("/path/photo002.jpg", "photo002", "jpg"),
                    File("/path/photo003.CR2", "photo003", "CR2")
            ))

            service.deleteDuplicatesWithExtension("/path", "jpg")

            verify(fileSystemMock).delete(File("/path/photo002.jpg", "photo002", "jpg"))
        }

        it("should not delete a photo file if photo is not available in other format") {
            val fileSystemMock: FileSystem = mock()
            val service = PhotosService(fileSystemMock)
            whenever(fileSystemMock.listFiles("/path")).thenReturn(setOf(
                    File("/path/photo001.CR2", "photo001", "CR2"),
                    File("/path/photo002.jpg", "photo002", "jpg"),
                    File("/path/photo003.CR2", "photo003", "CR2")
            ))

            service.deleteDuplicatesWithExtension("/path", "jpg")

            verify(fileSystemMock, never()).delete(any())
        }
    }

})