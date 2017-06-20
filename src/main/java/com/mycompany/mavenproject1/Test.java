/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Dell
 */
public class Test
{
  private int queueSize = 10;
  private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);
  public static void main(String[] args)
  {
    Test test = new Test();
    Producer producer = test.new Producer();
    Consumer consumer = test.new Consumer();
    producer.start();
    consumer.start();
  }
  class Consumer extends Thread
  {
    @Override
    public void run()
    {
      consume();
    }

    private void consume()
    {
      while (true)
      {
        try
        {
          queue.take();
          System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
        } catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
  class Producer extends Thread
  {
    @Override
    public void run()
    {
      produce();
    }
    private void produce()
    {
      while (true)
      {
        try
        {
          queue.put(1);
          System.out.println("向队列取中插入一个元素，队列剩余空间："+ (queueSize - queue.size()));
        } catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
}
