package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class LittleEndianByteArray$UnsafeByteArray$3 implements PrivilegedExceptionAction {
   public Unsafe run() {
      Class var1 = Unsafe.class;
      Field[] var2 = var1.getDeclaredFields();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Field var5 = var2[var4];
         var5.setAccessible(true);
         Object var6 = var5.get((Object)null);
         if(var1.isInstance(var6)) {
            return (Unsafe)var1.cast(var6);
         }
      }

      throw new NoSuchFieldError("the Unsafe");
   }
}
