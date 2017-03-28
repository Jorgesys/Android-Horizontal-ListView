package com.jorgesys.recyclerviewHorizontal;



public class Person {

    private String name;
    private int age;
    private String urlImage;

    public Person(String name, int age, String urlImage) {
        this.name = name;
        this.age = age;
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

}
