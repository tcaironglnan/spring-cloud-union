1. # 问题总结
    # (1) 如果在配置确认没有问题的情况下出现访问不到路径的的问题:
        1)没有把主函数的类放到根目录下,即:包路径如果是com.abc.cd  则需要放在com.abc下的包内
    
    # (2)springBoot对jsp的兼容不是很好,所以使用jsp的话,则需要做些特殊的准备,否则返回页面的时候会报404
        1)在配置文件中添加:
            # spring.mvc.view.prefix=/WEB-INF/views/
            # spring.mvc.view.suffix=.jsp
        
        2)在pom.xml文件中把依赖做些修改:
            # 添加jasper依赖,并且把原本都的<scope>标签改为<version>标签,指定对应需要的版本
            # 添加jstl依赖 
           
    # (3) 关于扫描映射接口报错问题:
        1)在springBoot的主函数的类上添加:
            # @MapperScan("com.springboot.dao")
        2)如果未加1),则会报错:
            #Field userModelMapper in UserServiceImpl
             required a bean of type 'UserModelMapper' that could not be found