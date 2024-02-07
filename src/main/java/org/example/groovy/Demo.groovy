package org.example.groovy

class Demo {

    void hello() {
        def user = new User()
        user.setName("张三")
        user.setAge(11)
        println user.getName()
        println user.getAge()
        //业务逻辑
        println "Hello Groovy"
    }
}
