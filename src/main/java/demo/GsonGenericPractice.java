package demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import practice.MyPattern;

import java.util.Map;

public class GsonGenericPractice {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();

        Human human = new Human();
        human.setName("angus");
        human.setSetting("{\"max\":{\"aaa\":100, \"bbb\":200}, \"age\":1}");

        HumanGson<HumanDetail> humanGson = new HumanGson<>();
        humanGson.setName(human.getName());
        humanGson.setSetting(gson.fromJson(human.getSetting(), HumanDetail.class));

        System.out.println(gson.toJson(humanGson));
    }

    private static class Human {
        private String name;
        private String setting;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSetting() {
            return setting;
        }

        public void setSetting(String setting) {
            this.setting = setting;
        }
    }

    private static class HumanGson<T> {
        private String name;
        private T setting;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public T getSetting() {
            return setting;
        }

        public void setSetting(T setting) {
            this.setting = setting;
        }
    }

    private static class HumanDetail {
        private int age;
        private Map<MyPattern, Long> max;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Map<MyPattern, Long> getMax() {
            return max;
        }

        public void setMax(Map<MyPattern, Long> max) {
            this.max = max;
        }
    }
}
