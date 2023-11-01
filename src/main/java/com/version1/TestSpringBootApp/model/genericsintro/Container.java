package com.version1.TestSpringBootApp.model.genericsintro;

import java.util.List;

public class Container<T> {

    private List<T> contentList;

    public List<T> getContentList() {
        return contentList;
    }

    public void setContentList(List<T> contentList) {
        this.contentList = contentList;
    }
}
