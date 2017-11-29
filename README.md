# kotlin和springboot整合例子

整合了最新版本的kotlin 1.1.60和springboot 2.0.0.M6，提供了最简单的CRUD例子。


## How to run
### gradle run:

环境要求：java>=jdk1.8,gradle>=4.x

    1. git clone https://github.com/peterchen82/kotlin-in-springboot.git
    2. cd kotlin-in-springboot&&gradle bootRun

### docker run:
环境要求：java>=jdk1.8,gradle>=4.x,docker>=12.3

    1. git clone https://github.com/peterchen82/kotlin-in-springboot.git
    2. cd kotlin-in-springboot&&gradle assemble
    3. docker build -t kotlin-in-springboot .
    4. docker run -p 8080:8080 --link mysql:mysql kotlin-in-springboot

    --link mysql 代表连接到mysql容器,默认连接mysql的账户是root:password

### 编译

环境要求：java>=jdk1.8,gradle>=4.x

    1. git clone https://github.com/peterchen82/iaac4j.aliyun.git
    2. cd iaac4j.aliyun&&gradle assemble


