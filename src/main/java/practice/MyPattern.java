package practice;

import com.google.gson.annotations.SerializedName;

public enum MyPattern {
    @SerializedName("aaa")
    AAA("aaa"),

    @SerializedName("bbb")
    BBB("bbb");

    private final String name;

    MyPattern(String name) {
        this.name = name;
    }
}
