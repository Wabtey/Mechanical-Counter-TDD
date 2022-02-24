package compteur

/**
 * La classe des compteurs paramétrés par une liste non vide de valeurs maximale pour chaque roue.
 *  La liste ne peut être vide et les valeurs sont forcément positives ou nulles
 */
class CompteurImpl extends Compteur {
  var rouesMax:List[Int] = List(0)
  var rouesActuelles:List[Int] = List(0)
  
  def init(l: List[Int]) = {
      if(l!=List()) {
        rouesMax = l;
        if(l.size==2)
          rouesActuelles = List(0,0)
      }
  }
  
  def courant = {rouesActuelles}
  
  def suivant = {
    rouesActuelles match{
      case e::Nil => if(suivantPossible) rouesActuelles = (e+1)::Nil
      case e1::e2::Nil =>
        if (suivantPossible) {
          rouesMax match {
            case eMax1 :: eMax2 :: Nil =>
              if (eMax2 == e2) rouesActuelles = List(e1 + 1, 0)
              else rouesActuelles = List(e1, e2 + 1)
          }
        }
    }
  }
  
  def suivantPossible = {
    rouesActuelles match {
      case e::Nil => 
        rouesMax match{
          case eMax::Nil => (eMax>e)
        }
      case e1::e2::Nil => 
        rouesMax match {
          case eMax1::eMax2::Nil => (eMax2>e2 || eMax1>e1)
        }
    }
  }
  
  def valPossibles = {
    rouesMax match{
      case e::Nil => e+1
      case e1::e2::Nil => (e1+1) * (e2+1)
    }
  }
  
  def valRestantes = {
    rouesActuelles match{
      case e::Nil => valPossibles - (e+1)
    }
  }
}