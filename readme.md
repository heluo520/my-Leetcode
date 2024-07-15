---
title: 目录结构
author: holo
---
## 目录结构
- datastruct目录：下面为自定义数据结构的实现
- other目录：一些其它内容
- sf目录：leetcode题单的题解
- sort目录：基本排序算法的实现
- ProxyFactory类：其静态方法`getProxyInstance(Object target)`产生一个`targer`对象的代理对象，对其中的`run(Object...args)`方法进行了增强，即打印方法的执行时间。需要增强的方法可以实现`PrintRunTime`接口将你需要运行的代码写入被重写的`run`方法中即可，然后在`main()`方法中使用`PrintRunTime`接口中的静态方法`proxyRun(T target,Object...args)`传入目标对象和相应方法参数即可运行相应方法并输出其执行时间。可以将这个run方法简单理解为main方法，将你要运行的内容写入其中即可。