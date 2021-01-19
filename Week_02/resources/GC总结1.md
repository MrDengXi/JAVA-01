对GC的总结：
1、SerialGC(串行化)
执行各个参数：java -XX:+UseSerialGC -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.log GCLogAnalysis
在堆内存大小为512M的前提下，生成对象9040，SerialGC共发生14次Minor GC，3次Full GC，最大GC时间近60ms，程序运行1s，GC总时间在630ms，大部分时间花在GC上。
调整JVM堆内存大小之后（256M），生成对象4210，在8次Minor GC后，一直发生Full GC（21次）。
继续调整JVM堆内存大小（128M），在8次Minor GC后，一直发生Full GC，最后产生OOM错误，内存溢出。
增大JVM堆内存大小（1024M），产生7次Minor GC，平均每次耗时80ms左右，生成对象7433。
增大JVM堆内存大小（2048M），产生4次Minor GC，平均每次耗时100ms左右，生成对象10527。
增大JVM堆内存大小（3g），产生1次Minor GC，平均每次耗时200ms左右，生成对象5932。(可能后一次GC还没结束，程序就已经结束了)

SerialGC总结：
JVM的堆内存大小会影响到SerialGC策略，在堆内存较小时，会导致频繁的Full GC（理解根本原因是GC的回收速率赶不上对象的分配速率，导致频繁Full FC），在堆内存过小，频繁
Full GC后甚至会导致OOM，内存溢出。在堆内存较大时，会导致每次GC的时间变长，从而使得GC线程长时间占用cpu，导致系统的吞吐量下降。


2、ParallelGC（并行GC）
执行各个参数：java -XX:+UseParallelGC -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
在堆内存大小为512M的前提下，生成对象8800左右，共发生27次Minor GC，12次Full GC，平均耗时在16ms。总耗时630ms。
继续调整JVM堆内存大小（256M），直接产生OOM错误，内存溢出。
增大JVM堆内存大小（1g），产生20次Minor GC，1次Full GC，平均每次耗时22ms左右，生成对象10000左右。
增大JVM堆内存大小（2g），产生7次Minor GC，平均每次耗时20ms左右，生成对象12000左右。
增大JVM堆内存大小（3g），产生1次Minor GC，平均每次耗时130ms左右，生成对象5000左右。

ParallelGC总结：
JVM的堆内存大小同样会影响到ParallelGC的策略，大致跟SerialGC结果一致，对比SerialGC，ParallelGC在GC的平均GC耗时有所下降，吞吐量相对而言有所提升。

3、CMSGC（并发GC）
执行各个参数：java -XX:+UseConcMarkSweepGC -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.cms.log  GCLogAnalysis
在堆内存大小为256M的前提下，生成对象4346左右，共发生Young GC 18次，消耗时间380ms，Full GC 12次 消耗360ms，整个GC的STW时间为740ms，其余时间为跟用户线程并发执行
在堆内存大小为512M的前提下，生成对象10000左右，共发生Young GC 16次，消耗时间410ms，Full GC 3次 消耗180ms，整个GC的STW时间为590ms，其余时间为跟用户线程并发执行
在堆内存大小为1g的前提下，生成对象12500左右，共发生Young GC 11次，消耗时间430ms，Full GC 1次 消耗70ms，整个GC的STW时间为500ms，其余时间为跟用户线程并发执行
在堆内存大小为2g的前提下，生成对象12500左右，共发生Young GC 6次，消耗时间410ms，Full GC 0次，整个GC的STW时间为410ms，其余时间为跟用户线程并发执行
在堆内存大小为4g的前提下，生成对象12500左右，共发生Young GC 6次，消耗时间440ms，Full GC 0次，整个GC的STW时间为440ms，其余时间为跟用户线程并发执行

CMS总结：
JVM的堆内存大小同样会影响到ParallelGC的策略，但是CMSGC在标记阶段会与用户进程并发执行。可以提升吞吐量。


4、G1GC
执行各个参数：java -XX:+UseG1GC -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.g1.log  GCLogAnalysis
在堆内存大小为512M的前提下，生成对象10500左右，




