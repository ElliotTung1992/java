package com.github.demo.thread;


import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 董感恩
 * @date 2020-08-11 15:55
 * @desc
 *
 *  线程池源码学习
 *
 *  背景：多核计算机成为主流，并行处理成为开发者优化性能的必备武器
 *
 *  1.线程池的作用
 *    1.1 - 避免处理任务时创建销毁线程开销代价
 *    1.2 - 避免线程数量膨胀导致过度调度的问题，保证内核的充分利用
 *
 *  2.线程池的好处
 *    2.1 - 降低资源消耗
 *    2.2 - 提高响应速度
 *  *    2.3 - 提高线程的可管理型
 *  *    2.4 - 提供更多更强大的功能
 *  *
 *  3.线程池思想
 *    3.1 - 为了解决资源分配问题，线程池采用了池化的思想
 *          池化，顾名思义，是为了最大收益并最小风险
 *          而将资源统一管理的思想
 *
 *
 *  4.总体设计
 *    线程池的内部实际上构建了一个生产者消费者模型
 *    将线程和任务进行解藕，并不直接关联，从而良好的缓存任务，复用线程
 *    生产者：
 *      任务管理充当生产者的角色
 *      任务提交后，线程池会判断任务的后续流程
 *      1.直接申请线程执行该任务
 *      2.缓存到队列中进行等待
 *      3.拒绝该任务
 *    消费者：
 *      线程管理充当消费者的角色
 *      它们被统一维护在线程池内，根据任务请求进行线程的分配，
 *      当线程执行完任务后则会继续获取新的任务去执行，最终当线程获取不到任务的时候，线程就会被回收。
 *
 *   5.线程池的运行机制
 *      5.1 线程池如何维护自身状态。
 *      5.2 线程池如何管理任务。
 *      5.3 线程池如何管理线程。
 *
 *
 *
 */
public class ThreadPoolExecutorTest {

    // 32 - 3 = 29
    static int COUNT_BITS = Integer.SIZE - 3;
    // 1 << 29 - 1 = 11111111111111111111111111111
    static int CAPACITY   = (1 << COUNT_BITS) - 1;

    //-1原码: 10000000 00000000 00000000 00000001
    //-1反码: 11111111 11111111 11111111 11111110
    //-1补码: 11111111 11111111 11111111 11111111
    // -1 << 29
    //11100000 00000000 00000000 00000000
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        //threadPoolExecutorLifeCycle();
        //test();
        //useCase();
        //test2();
        //test3();

        test4();

        //test5();
    }

    private static void test5() throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println("This is ThreadPoolExetor#submit(Callable<T> task) method.");
                return "result";
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(callable);
        System.out.println(future.get());
    }

    private static void test4() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy());

        Callable<Integer> callable = () -> {
            return 1;
        };

        Future<?> future = threadPoolExecutor.submit(callable);

        Object o = future.get();

        System.out.println(o);
    }

    private static void test3() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy());

        Runnable runnable = () -> {
            System.out.println("haha");
        };

        threadPoolExecutor.execute(runnable);
    }

    private static void test2() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy());

        long beginTime = System.nanoTime();

        FutureTask<Object> futureTask = new FutureTask<>(() -> {
            methodOne();
            return true;
        });

        Callable callableTwo = () -> {
            methodTwo();
            return true;
        };

        Callable callableThree = () -> {
            methodThree();
            return true;
        };

        Future futureOne = threadPoolExecutor.submit(futureTask);
        Future futureTwo = threadPoolExecutor.submit(callableTwo);
        Future submitThree = threadPoolExecutor.submit(callableThree);

        try {
            while (true){
                Boolean bTwo = (Boolean) futureTwo.get(6, TimeUnit.SECONDS);
                System.out.println(bTwo);
                if(bTwo){
                    break;
                }
                Boolean bThree = (Boolean) submitThree.get(6, TimeUnit.SECONDS);
                System.out.println(bThree);
                Boolean bOne = (Boolean) futureOne.get(11, TimeUnit.SECONDS);
                System.out.println(bOne);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime() - beginTime;
        System.out.println(endTime);
    }

    public static void methodOne(){
        System.out.println("methodOne");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void methodTwo(){
        System.out.println("methodTwo");
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void methodThree(){
        System.out.println("methodThree");
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author 董感恩
     * @date 2020-08-17 13:28:36
     * @desc 不推荐直接使用Executors的方式去创建线程池
     *
     **/
    //使用案例
    private static void useCase() {
        //核心线程数为0
        //最大线程数为integer的最大值
        //阻塞队列是SynchronousQueue，没有存储空间
        //线程失效时间是60s
        //=============
        //综上所述，这个线程池可以理解为无限长度
        //因为阻塞队列是SynchronousQueue，所以当有新的任务
        //进来时，必须要有线程处理他，如果没有，则新建线程处理
        //线程空闲时间超过60s则会被回收
        //=============
        //这个适合于任务响应快，执行时间短的异步任务
        //如果任务响应时间长，会大量创建新的线程，容易造成OOM
        ExecutorService executorService = Executors.newCachedThreadPool();

        //核心线程数为1
        //最大线程数为1
        //阻塞队列为LinkedBlockingQueue
        //线程失效时间是0s
        //=============
        //综上所述，这个线程池是最大只能是1
        //队列是LinkedBlockingQueue，默认长度是Integer的最大值
        //=============
        //这个适用于需要顺序执行的异步任务
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        //核心线程数由用户定义
        //最大线程数是integer的最大值
        //阻塞队列是DelayedWorkQueue
        //线程失效时间是0s
        ScheduledExecutorService executorService2 = Executors.newScheduledThreadPool(5);
        Runnable runnable = () -> {
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("延迟执行");
        };
        //两次执行的时间间隔
        //executorService2.scheduleAtFixedRate(runnable, 1, 3, TimeUnit.SECONDS);
        //上一次的终止和这一次的开始时间间隔
        //executorService2.scheduleWithFixedDelay(runnable, 1, 3, TimeUnit.SECONDS);

        //核心线程数由用户自己决定
        //最大线程数由用户自己决定
        //阻塞队列为LinkedBlockingQueue
        //线程失效时间是0s
        //=============
        //综上所述，这个线程池是最大由用户自己决定
        //队列是LinkedBlockingQueue，默认长度是Integer的最大值
        //=============
        //这是一个有固定大小的无界队列线程池
        ExecutorService executorService3 = Executors.newFixedThreadPool(5);
    }

    private static void test() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5, 5, 1000l, TimeUnit.SECONDS, new ArrayBlockingQueue(5));
        pool.execute(null);
    }

    //线程池的生命周期
    private static void threadPoolExecutorLifeCycle() {
        //-536870912
        AtomicInteger ctl = new AtomicInteger(ctlOf(-1 << COUNT_BITS,0));
        System.out.println(ctl.get());

        System.out.println("-536870912的二进制:" + Integer.toBinaryString((-1 << COUNT_BITS)));

        //11100000000000000000000000000000
        //11100000000000000000000000000000 &
        //11100000000000000000000000000000
        int runState = runStateOf(ctl.get());
        System.out.println("RUNNING线程的运行状态是:" + runState);

        //00000000000000000000000000000000
        //11100000000000000000000000000000 &
        //00000000000000000000000000000000
        int runState2 = runStateOf(SHUTDOWN);
        System.out.println("SHUTDOWN线程的运行状态是:" + runState2);

        //00100000000000000000000000000000
        //11100000000000000000000000000000 &
        //00100000000000000000000000000000
        int runState3 = runStateOf(STOP);
        System.out.println("STOP线程的运行状态是:" + runState3);

        //01000000000000000000000000000000
        //11100000000000000000000000000000 &
        //01000000000000000000000000000000
        int runState4 = runStateOf(TIDYING);
        System.out.println("TIDYING线程的运行状态是:" + runState4);

        //01100000000000000000000000000000
        //11100000000000000000000000000000 &
        //01100000000000000000000000000000
        int runState5 = runStateOf(TERMINATED);
        System.out.println("TERMINATED线程的运行状态是:" + runState5);

        //11100000000000000000000000000000
        //00011111111111111111111111111111 &
        //00000000000000000000000000000000
        int workerCount = workerCountOf(ctl.get());
        System.out.println("工作线程的个数是:" + workerCount);
    }

    //获取线程池状态
    static int runStateOf(int c){
        //高三位都是1,只对高三位进行运算
        //~CAPACITY = 11100000000000000000000000000000
        return c & ~CAPACITY;
    }

    //获取工作线程的数量
    static int workerCountOf(int c){
        //低29位都是1,只对低29位进行运算
        //CAPACITY = 11111111111111111111111111111
        return c & CAPACITY;
    }

    //通过线程池状态和工作线程计算
    static int ctlOf(int rs, int wc) {
        return rs | wc;
    }
}
