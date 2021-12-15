import org.junit.Test
import org.junit.Assert.*

class Test1:
  @Test def t1(): Unit = 
    assertEquals(2, fib(2))
    assertEquals(2, fib_toc(10))
