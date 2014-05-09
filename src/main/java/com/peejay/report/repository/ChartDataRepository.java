package com.peejay.report.repository;

import com.peejay.table.AnotherObject;
import com.peejay.table.SomeObject;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ChartDataRepository {

    public String getText() {
        return "Lorem ipsum....";
    }

    public List<SomeObject> getSomeObjects() {
        SomeObject s1 = new SomeObject("Foo 1", "Bar 1", "Baz 1");
        SomeObject s2 = new SomeObject("Foo 2", "Bar 2", "Baz 2");
        SomeObject s3 = new SomeObject("Foo 3", "Bar 3", "Baz 3");
        return Arrays.asList(s1, s2, s3);
    }

    public List<AnotherObject> getAnotherObjects() {
        AnotherObject s1 = new AnotherObject("String 1:1", "String 1:2");
        AnotherObject s2 = new AnotherObject("String 2:1", "String 2:2");
        return Arrays.asList(s1, s2);
    }

}
