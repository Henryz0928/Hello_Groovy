package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

/**
 * Hello world!
 */
@SpringBootApplication
@RestController
public class App {

    private static final GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

    private static final String groovyMethod = "hello";

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/test")
    public void testApp() {
//        File groovy = new File("src/main/java/org/example/groovy/Demo.groovy");
        File groovy = new File("C:\\Users\\zengn\\OneDrive\\WorkSpace\\Rust_Projects\\Demo.groovy");
        GroovyObject groovyObject = new App().loadGroovy(groovy);
        groovyObject.invokeMethod(groovyMethod, null);

    }

    public GroovyObject loadGroovy(File file) {
        try {
            //将Groovy脚本解析为可以运行的Java类
            Class<?> groovyClass = groovyClassLoader.parseClass(file);
            //返回该类的实例化对象
            return (GroovyObject) groovyClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("解析Groovy脚本异常！");
        }
    }
}
