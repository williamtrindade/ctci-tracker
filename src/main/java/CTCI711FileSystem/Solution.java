package CTCI711FileSystem;

import java.util.List;

public class Solution {

    public abstract static class Entry {
        protected Entry(String name, Directory parent) {
            // TODO: Implement CTCI 7.11 File System
        }

        public String getName() {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }

        public Directory getParent() {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }

        public String getFullPath() {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }

        public abstract int size();

        public boolean delete() {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }

        public void rename(String newName) {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }
    }

    public static class File extends Entry {
        public File(String name, Directory parent, String content) {
            super(name, parent);
        }

        @Override
        public int size() {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }

        public String getContent() {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }

        public void setContent(String content) {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }
    }

    public static class Directory extends Entry {
        public Directory(String name, Directory parent) {
            super(name, parent);
        }

        @Override
        public int size() {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }

        public int numberOfFiles() {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }

        public List<Entry> getContents() {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }

        public Entry resolve(String relativePath) {
            throw new UnsupportedOperationException("TODO: CTCI 7.11 File System");
        }
    }
}
