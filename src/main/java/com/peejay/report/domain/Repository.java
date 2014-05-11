package com.peejay.report.domain;

import com.peejay.report.domain.AnotherObject;
import com.peejay.report.domain.SomeObject;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class Repository {

    public String getText() {
        return "Lorem ipsum....";
    }

    public List<SomeObject> getSomeObjects() {
        SomeObject o1 = new SomeObject("Foo 1", "Bar 1", "Baz 1");
        SomeObject o2 = new SomeObject("Foo 2", "Bar 2", "Baz 2");
        SomeObject o3 = new SomeObject("Foo 3", "Bar 3", "Baz 3");
        return Arrays.asList(o1, o2, o3);
    }

    public List<AnotherObject> getAnotherObjects() {
        AnotherObject o1 = new AnotherObject("String 1:1", "String 1:2");
        AnotherObject o2 = new AnotherObject("String 2:1", "String 2:2");
        return Arrays.asList(o1, o2);
    }

    public List<ThirdObject> getThirdObjects() {
        ThirdObject o1 = new ThirdObject("Text 1", 10.543d, Calendar.getInstance().getTime());
        ThirdObject o2 = new ThirdObject("Text 2", 0.5d, Calendar.getInstance().getTime());
        return Arrays.asList(o1, o2);
    }
}
