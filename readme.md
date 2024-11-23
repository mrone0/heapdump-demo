# 背景介绍
是每一个new 出来的User对象，被强引用，uer对象里面会强引用LIke对象，
我引用的Like对象本身会放在wekhashmap里，这样如果user对象被回收了，那么LIke对象也会被回收。
那么我的weakHashmap，在自动GC时，就会将没有强引用的key等进行自动回收。所以我的效果是
User -> LIKE  -> User
WEAKHASHMAP -> Like


1000个User对象，1000个like对象

List -> USER USER ALLlIKES -> LIKE 
Like -> WEAKHASHMAP 被识别到强引用，无法被GC

整个OOM

占大头的其实是List的User对象

问题：如果不是List的User对象过多导致的OOM,程序会OOM吗？
答案：会的

User对象被强引用，无法被回收
User 强引用了我的LIKE对象，Like对象也就无法被回收，
同时 我weakHashMap在收到GC命令时，识别到我的Value里的Like对象被强引用
都无法被回收，导致对象进入老年代，最终对象过多，OOM
