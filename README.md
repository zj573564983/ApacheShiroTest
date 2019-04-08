# ApacheShiroTest
这是对ApacheShiro安全框架的一个初步使用。

- 实现了自己的登录，通过login.jsp实现
- 数据库也设定了指定的角色，每个角色跟指定权限对应，而每个用户对应一个角色
- 其中我们引入了阿里的Druid，Druid是目前非常流行的java数据库连接池。在本项目中可以通过127.0.0.1:8080/druid/index.html查看监控信息。

这个项目在安装mysql数据之后是可以运行的，当然之后apacheshiro框架肯定会有更新，以及druid等库的更新。
如果出现问题，可以先看下是不是jdk、springboot框架与druid不匹配。

