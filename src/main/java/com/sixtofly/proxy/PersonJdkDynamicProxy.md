# com.sun.proxy.$Proxy0
``` java
import com.sun.proxy.;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class Proxy0 extends Proxy implements .Proxy0 {
  private static Method m1;
  
  private static Method m7;
  
  private static Method m2;
  
  private static Method m8;
  
  private static Method m12;
  
  private static Method m14;
  
  private static Method m0;
  
  private static Method m9;
  
  private static Method m4;
  
  private static Method m13;
  
  private static Method m6;
  
  private static Method m11;
  
  private static Method m5;
  
  private static Method m3;
  
  private static Method m10;
  
  public Proxy0(InvocationHandler paramInvocationHandler) {
    super(paramInvocationHandler);
  }
  
  public final boolean equals(Object paramObject) {
    try {
      return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final InvocationHandler getInvocationHandler(Object paramObject) throws IllegalArgumentException {
    try {
      return (InvocationHandler)this.h.invoke(this, m7, new Object[] { paramObject });
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final String toString() {
    try {
      return (String)this.h.invoke(this, m2, null);
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final Class getProxyClass(ClassLoader paramClassLoader, Class[] paramArrayOfClass) throws IllegalArgumentException {
    try {
      return (Class)this.h.invoke(this, m8, new Object[] { paramClassLoader, paramArrayOfClass });
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final Class getClass() {
    try {
      return (Class)this.h.invoke(this, m12, null);
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final void notifyAll() {
    try {
      this.h.invoke(this, m14, null);
      return;
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final int hashCode() {
    try {
      return ((Integer)this.h.invoke(this, m0, null)).intValue();
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final void wait() throws InterruptedException {
    try {
      this.h.invoke(this, m9, null);
      return;
    } catch (Error|RuntimeException|InterruptedException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final Object pay() {
    try {
      return this.h.invoke(this, m4, null);
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final void notify() {
    try {
      this.h.invoke(this, m13, null);
      return;
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final Object newProxyInstance(ClassLoader paramClassLoader, Class[] paramArrayOfClass, InvocationHandler paramInvocationHandler) throws IllegalArgumentException {
    try {
      return this.h.invoke(this, m6, new Object[] { paramClassLoader, paramArrayOfClass, paramInvocationHandler });
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final void wait(long paramLong) throws InterruptedException {
    try {
      this.h.invoke(this, m11, new Object[] { Long.valueOf(paramLong) });
      return;
    } catch (Error|RuntimeException|InterruptedException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final boolean isProxyClass(Class paramClass) {
    try {
      return ((Boolean)this.h.invoke(this, m5, new Object[] { paramClass })).booleanValue();
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final Object buy() {
    try {
      return this.h.invoke(this, m3, null);
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final void wait(long paramLong, int paramInt) throws InterruptedException {
    try {
      this.h.invoke(this, m10, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return;
    } catch (Error|RuntimeException|InterruptedException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  static {
    try {
      m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
      m7 = Class.forName("com.sun.proxy.$Proxy0").getMethod("getInvocationHandler", new Class[] { Class.forName("java.lang.Object") });
      m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
      m8 = Class.forName("com.sun.proxy.$Proxy0").getMethod("getProxyClass", new Class[] { Class.forName("java.lang.ClassLoader"), Class.forName("[Ljava.lang.Class;") });
      m12 = Class.forName("com.sun.proxy.$Proxy0").getMethod("getClass", new Class[0]);
      m14 = Class.forName("com.sun.proxy.$Proxy0").getMethod("notifyAll", new Class[0]);
      m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
      m9 = Class.forName("com.sun.proxy.$Proxy0").getMethod("wait", new Class[0]);
      m4 = Class.forName("com.sun.proxy.$Proxy0").getMethod("pay", new Class[0]);
      m13 = Class.forName("com.sun.proxy.$Proxy0").getMethod("notify", new Class[0]);
      m6 = Class.forName("com.sun.proxy.$Proxy0").getMethod("newProxyInstance", new Class[] { Class.forName("java.lang.ClassLoader"), Class.forName("[Ljava.lang.Class;"), Class.forName("java.lang.reflect.InvocationHandler") });
      m11 = Class.forName("com.sun.proxy.$Proxy0").getMethod("wait", new Class[] { long.class });
      m5 = Class.forName("com.sun.proxy.$Proxy0").getMethod("isProxyClass", new Class[] { Class.forName("java.lang.Class") });
      m3 = Class.forName("com.sun.proxy.$Proxy0").getMethod("buy", new Class[0]);
      m10 = Class.forName("com.sun.proxy.$Proxy0").getMethod("wait", new Class[] { long.class, int.class });
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new NoSuchMethodError(noSuchMethodException.getMessage());
    } catch (ClassNotFoundException classNotFoundException) {
      throw new NoClassDefFoundError(classNotFoundException.getMessage());
    } 
  }
}

```