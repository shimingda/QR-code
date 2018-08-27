package com.dome.jackson;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.JsonParseException;

import java.io.IOException;

/**
 * ObjectMapper类是Jackson库的主要类。
 * 它提供一些功能将转换成Java对象匹配JSON结构，反之亦然。
 * 它使用JsonParser和JsonGenerator的实例实现JSON实际的读/写。
 */

public class ObjectMapperDome {
    public static void main(String args[]){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        //map json to student
        try {
            Student student = mapper.readValue(jsonString, Student.class);
            System.out.println(student.getAge());

            jsonString = mapper.writeValueAsString(student);
            System.out.println(jsonString);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Student {
    private String name;
    private int age;
    public Student(){}
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
    public String toString(){
        return "Student [ name: "+name+", age: "+ age+ " ]";
    }
}

