package compteur

import org.junit.Test
import org.junit.Assert._



class TestCompteur {
  val c:Compteur= new CompteurImpl()
  
  
  @Test
  def testGlobal{
    c.init(List(1))
    assertTrue(c.suivantPossible)
    assertEquals(2,c.valPossibles)
    assertEquals(List(0),c.courant)
    assertTrue(c.suivantPossible)
    c.suivant
    assertEquals(List(1),c.courant)
    assertFalse(c.suivantPossible)
  }
    
  @Test
  def testInit1{
    c.init(List())
    assertEquals(List(0),c.courant)
  }
  
  @Test
  def testInit2{
    c.init(List(2))
    assertEquals(List(0),c.courant)
  }
  
  @Test
  def testInitDeuxRoues1{
    c.init(List(0, 0))
    assertEquals(List(0, 0),c.courant)
  }
  
  @Test
  def testSuivant1{
    c.init(List(10))
    c.suivant
    assertEquals(List(1),c.courant)
  }
  
  @Test
  def testSuivant2{
    c.init(List())
    c.suivant
    assertEquals(List(0),c.courant)
  }
  
  @Test
  def testSuivant3{
    val max = 15
    c.init(List(max))
    for( i <- 0 to max){
      c.suivant
    }
    assertEquals(List(max),c.courant)
  }
  
  @Test
  def testSuivantDeuxRoues1{
    c.init(List(0,0))
    c.suivant
    assertEquals(List(0,0),c.courant)
  }
  
  @Test
  def testSuivantDeuxRoues2{
    c.init(List(22,17))
    c.suivant
    assertEquals(List(0,1),c.courant)
  }
  
  @Test
  def testSuivantDeuxRoues3{
    c.init(List(22,0))
    c.suivant
    assertEquals(List(1,0),c.courant)
  }
  
  @Test
  def testSuivantDeuxRoues4{
    c.init(List(22,1))
    c.suivant
    c.suivant
    assertEquals(List(1,0),c.courant)
  }
  
  @Test
  def testSuivantPossibleDeuxRoues1{
    c.init(List(0,0))
    assertFalse(c.suivantPossible)
  }
  
  @Test
  def testSuivantPossibleDeuxRoues2{
    c.init(List(0,1))
    assertTrue(c.suivantPossible)
  }
  
  @Test
  def testSuivantPossibleDeuxRoues3{
    c.init(List(1,0))
    assertTrue(c.suivantPossible)
  }
  
  @Test
  def testValPossible1{
    c.init(List())
    assertEquals(1, c.valPossibles)
  }
  
  @Test
  def testValPossible2{
    c.init(List(5))
    assertEquals(6, c.valPossibles)
  }
  
  @Test
  def testValPossibles2R1{
    c.init(List(0,0))
    assertEquals(1, c.valPossibles)
  }
  
  @Test
  def testValPossibles2R2{
    c.init(List(0,5))
    assertEquals(6, c.valPossibles)
  }
  
  @Test
  def testValPossibles2R3{
    c.init(List(5,0))
    assertEquals(6, c.valPossibles)
  }
  
  @Test
  def testValPossibles2R4{
    c.init(List(1,2))
    assertEquals(6, c.valPossibles)
  }
  
  @Test
  def testValRestantes1{
    c.init(List())
    assertEquals(0, c.valRestantes)
  }
  
  @Test
  def testValRestantes2{
    c.init(List(100))
    assertEquals(100, c.valRestantes)
  }
  
  @Test
  def testValRestantes3{
    c.init(List(10))
    c.suivant
    assertEquals(9, c.valRestantes)
  }
  
  @Test
  def testValRestantes2R1{
    c.init(List(0,0))
    assertEquals(0, c.valRestantes)
  }
  
 
}
