/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Dell
 */
public class Singleton {
   private volatile static Singleton instance;
   private Singleton(){
      
   }
   public static synchronized Singleton getIntance(){
          if (instance == null) {
            // 注意，只有第一次才彻底执行这里的代码
            synchronized (Singleton.class){
                // 进入区块后，再检查一次。如果仍是null，才创建实例
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
   }
}