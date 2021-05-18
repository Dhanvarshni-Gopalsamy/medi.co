package com.example.namachivaya.activities.HelperClasses;

public class FeaturedHelperClass {
    String name, age, problem, desc;

    public FeaturedHelperClass(String name, String age, String problem, String desc) {
        this.name = name;
        this.age = age;
        this.problem =problem;
        this.desc=desc;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getProblem() {
        return problem;
    }

    public String getDesc() {
        return desc;
    }
}
