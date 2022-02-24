package client

import compteur._
import tester.TestCompteurPrivate

object Client extends App {
  val c: Compteur = new CompteurImpl()
  TestCompteurPrivate.check(c)
}