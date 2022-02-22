package com.katas;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StorageTest {

    private Storage storage = new Storage();

    @Test
    public void should_have_a_root_directory() {
        Directory directory = storage.rootDirectory();

        assertThat(directory.name()).isEqualTo("/");
    }

    @Test
    public void should_have_a_total_size_of_zero_when_is_empty() {
        assertThat(storage.totalSize()).isZero();
    }

    @Test
    public void should_have_a_total_size_when_non_empty() {
        // given
        storage.rootDirectory().add(new File("file1", 100));

        Directory dir1 = new Directory("dir1");
        dir1.add(new File("file1", 50));
        storage.rootDirectory().add(dir1);

        // when
        int totalSize = storage.totalSize();

        // then
        assertThat(totalSize).isEqualTo(150);
    }
}
