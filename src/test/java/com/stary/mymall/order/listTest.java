package com.stary.mymall.order;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname listTest
 * @description
 * @create 2021/10/3-17:13
 */
public class listTest {

    class Person{
        private Integer id;
        private String name;

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        Person(Integer id, String name){
            this.id=id;
            this.name=name;
        }

    }


    @Test
    public void testList(){
        List<Person> personList=new ArrayList<>();
        personList.add(new Person(1,"zhangsan"));
        personList.add(new Person(3,"lisi"));
        personList.add(new Person(5,"王二"));
        personList.add(new Person(7,"麻子"));
        personList.add(new Person(9,"赵四"));

        System.out.println("list=="+personList);

        for (Person person:personList){
            if (person.id>4){
                person.setName("更新");
            }
        }


        System.out.println("listnew=="+personList);




    }
}
