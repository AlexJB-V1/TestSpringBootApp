package com.version1.TestSpringBootApp.service;

import org.springframework.stereotype.Service;

@Service
public class CodeQlTestService {

    public void problem() {
        Object[] o = new Object[] { "Hello", "world" };
        String[] s = (String[])o;
    }

    static public String selfAssignment(String o) {
        String s = "";
        s = s;
        return s;
    }

}
