package com.okstrishch.edu.comparator;

import java.util.Comparator;

public class ComparatorSearch {
 
        private boolean visibleByList;
        private String sortBy;
        private String show;
        private Comparator<String> comparator;

        public  ComparatorSearch(boolean visibleByList, String sortBy, String show, Comparator<String> comparator) {
            this.visibleByList = visibleByList;
            this.sortBy = sortBy;
            this.show = show;
            this.comparator = comparator;
        }

        public boolean isVisibleByList() {
            return visibleByList;
        }

        public String getSortBy() {
            return sortBy;
        }

        public String getShow() {
            return show;
        }

        public Comparator<String> getComparator() {
            return comparator;
        }

    }

