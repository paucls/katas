package com.katas;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectoryTest {
    @Test
    public void should_add_file() {
        Directory dir1 = new Directory("dir1");
        File file1 = new File("file1", 100);

        dir1.add(file1);

        assertThat(dir1.resources()).containsExactly(file1);
    }

    @Test
    public void should_allow_adding_a_directory() {
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        dir1.add(dir2);

        assertThat(dir1.resources()).containsExactly(dir2);
    }

    @Test
    public void should_calculate_its_size() {
        Directory dir1 = new Directory("dir1");
        dir1.add(new File("file1", 100));
        dir1.add(new File("file2", 50));

        int size = dir1.getSize();

        assertThat(size).isEqualTo(150);
    }
}
