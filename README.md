# edge_computing_service

##遇到的问题
* 运行项目报错：Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required
* 解决方式：删除所有配置文件（.iml、.idea、.mvvm等），删除pom文件里的spring-test包，将spring版本由2.1.3改为1.5.7，重新运行项目，此时还是报错，但是错误变为找不到ibatis这个依赖。尝试把pom文件里的依赖顺序调换了一下，就不报错了。具体出错原因不明，解决方法仅供参考，后续有时间再尝试查找问题原因。