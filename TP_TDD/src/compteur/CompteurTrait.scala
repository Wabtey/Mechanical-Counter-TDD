package compteur

trait Compteur {
  /**
   * initialisation du compteur.
   *  La liste l ne peut être vide et les valeurs sont forcément positives ou nulles
   *  @param l la liste non vide de valeurs maximales pour chaque roue.
   */
  def init(l: List[Int]): Unit

  /** @return la valeur courante du compteur */
  def courant: List[Int]

  /** incrémente le compteur (si cela est possible) */
  def suivant: Unit

  /** @return le compteur a-t-il atteint sa valeur maximale? */
  def suivantPossible: Boolean

  /** @return le nombre de valeurs possibles */
  def valPossibles: Int

  /** @return le nombre de valeurs restant */
  def valRestantes: Int
}