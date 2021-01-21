对GC的总结（执行时间调至1分钟）：
1、SerialGC(串行化)
执行各个参数：java -XX:+UseSerialGC -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.log GCLogAnalysis
调整JVM堆内存大小（256M），直接产生OOM错误，内存溢出。
在堆内存大小为512M的前提下，生成对象418439左右，共发生9次Minor GC,消耗时间240ms，926次Full GC，消耗时间43.4s。
在堆内存大小为1G的前提下，生成对象961841左右，共发生693次Minor GC,消耗时间12.2s，216次Full GC，消耗时间12.9s。
在堆内存大小为2G的前提下，生成对象1194640左右，共发生498次Minor GC,消耗时间16.2s，66次Full GC，消耗时间4.4s。
在堆内存大小为4G的前提下，生成对象712827左右，共发生291次Minor GC,消耗时间21.3s，10次Full GC，消耗时间3.38s。
在堆内存大小为8G的前提下，生成对象966202左右，共发生168次Minor GC,消耗时间11.8s，1次Full GC，消耗时间520ms。

SerialGC总结：
JVM的堆内存大小会影响到SerialGC策略，在堆内存较小时，会导致频繁的Full GC（理解根本原因是GC的回收速率赶不上对象的分配速率，导致频繁Full FC），在堆内存过小，频繁
Full GC后甚至会导致OOM，内存溢出。在堆内存较大时，会导致每次GC的时间变长，从而使得GC线程长时间占用cpu，导致系统的吞吐量下降。


2、ParallelGC（并行GC）
执行各个参数：java -XX:+UseParallelGC -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
调整JVM堆内存大小（256M），直接产生OOM错误，内存溢出。
在堆内存大小为512M的前提下，生成对象142570左右，共发生25次Minor GC,消耗时间300ms，1295次Full GC，消耗时间51.8s。
在堆内存大小为1G的前提下，生成对象869267左右，共发生1158次Minor GC,消耗时间15.8s，186次Full GC，消耗时间8.7s。
在堆内存大小为2G的前提下，生成对象1089377左右，共发生690次Minor GC,消耗时间16.8s，53次Full GC，消耗时间2.9s。
在堆内存大小为4G的前提下，生成对象1002331左右，共发生291次Minor GC,消耗时间21.3s，10次Full GC，消耗时间3.38s。
在堆内存大小为8G的前提下，生成对象1337349左右，共发生168次Minor GC,消耗时间11.8s，1次Full GC，消耗时间520ms。


ParallelGC总结：
JVM的堆内存大小同样会影响到ParallelGC的策略，大致跟SerialGC结果一致，对比SerialGC，ParallelGC在GC的平均GC耗时有所下降，吞吐量相对而言有所提升。随着堆内存大小变大，GC次数变小
但是GC时间变长，导致stw的时间反而没有减小。吞吐量没有太大变化。

3、CMSGC（并发GC）
执行各个参数：java -XX:+UseConcMarkSweepGC -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.cms.log  GCLogAnalysis
在堆内存大小为256M的前提下，OOM
在堆内存大小为512M的前提下，生成对象395988左右，共发生Young GC 801次，消耗时间43.1s，Full GC 3次 消耗150ms
在堆内存大小为1g的前提下，生成对象1159894左右，共发生Young GC 1018次，消耗时间17.59s，Full GC 73次 消耗4.43s
在堆内存大小为2g的前提下，生成对象1244143左右，共发生Young GC 547次，消耗时间16.8s，Full GC 36次，消耗时间2.23s
在堆内存大小为4g的前提下，生成对象1112821左右，共发生Young GC 516次，消耗时间23.3s，Full GC 1次，消耗时间70ms
在堆内存大小为8g的前提下，生成对象556356左右，共发生Young GC 265次，消耗时间40.74s

CMS总结：
JVM的堆内存大小同样会影响到CMSGC的策略，但是CMSGC在标记阶段会与用户进程并发执行。可以提升吞吐量。但是大内存使用CMSGC会导致young gc时间过长，影响吞吐。


4、G1GC
执行各个参数：java -XX:+UseG1GC -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.g1.log  GCLogAnalysis
在堆内存大小为512M的前提下，生成对象272958左右，共发生Young GC 3361次，耗时 5.04s, Full GC 889次，耗时 32.69s，Mixed GC 1442次，耗时 2.27s。
在堆内存大小为1G的前提下，生成对象869827左右，共发生Young GC 600次，耗时 7.99s, Mixed GC 1302次，耗时 9.68s。
在堆内存大小为2G的前提下，生成对象872907左右，共发生Young GC 247次，耗时 7.82s, Mixed GC 218次，耗时 3.24s。
在堆内存大小为4G的前提下，生成对象862608左右，共发生Young GC 153次，耗时 21.7s, Mixed GC 16次，耗时 1.3s。
在堆内存大小为8G的前提下，生成对象823392左右，共发生Young GC 172次，耗时 25.3s, Mixed GC 1次，耗时 120ms。

G1总结
随着堆内存的增大，GC次数明显降低，并且生成对象数量会有大大提升。



