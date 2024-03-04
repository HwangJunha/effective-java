package org.around.item84;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 코드 84-1 끔찍한 CountDownLatch 구현 - 바쁜 대기 버전! (447쪽)
public class SlowCountDownLatch {
    private int count;

    public SlowCountDownLatch(int count) {
        if (count < 0)
            throw new IllegalArgumentException(count + " < 0");
        this.count = count;
    }

    public void await() {
        while (true) {
            synchronized(this) {
                if (count == 0)
                    return;
            }
        }
    }
    public synchronized void countDown() {
        if (count != 0)
            count--;
    }
    public static void main(String[] args) throws InterruptedException {
        int nThreads = 1000;

        //SlowCountDownlatch 이용
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        SlowCountDownLatch slowCountDownLatch = new SlowCountDownLatch(nThreads);

        long start1 = System.nanoTime();
        for (int i = 0; i < nThreads; i++) {
            executorService.submit(() -> slowCountDownLatch.countDown());
        }

        slowCountDownLatch.await();
        executorService.shutdown();
        long end1 = System.nanoTime();
        System.out.printf("slowCountDownLatch : %s ", end1 - start1);

        //CountDownlatch 이용
        long start2 = System.nanoTime();
        ExecutorService executorService2 = Executors.newFixedThreadPool(nThreads);
        CountDownLatch countDownLatch = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            executorService2.submit(() -> countDownLatch.countDown());
        }
        countDownLatch.await();
        executorService2.shutdown();
        long end2 = System.nanoTime();
        System.out.printf("countDownLatch : %s ", end2 - start2);

    }
}
