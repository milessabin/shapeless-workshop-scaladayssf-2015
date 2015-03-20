package workshop

import shapeless._, poly._

case class Person(name: String, address: Address, pet: Pet)
case class Address(city: String, country: String)
case class Pet(name: String, species: String, age: Int)

sealed trait Tree[T]
case class Node[T](left: Tree[T], right: Tree[T]) extends Tree[T]
case class Leaf[T](value: T) extends Tree[T]

object inc extends ->((i: Int) => i+1)

object WorkshopDefns {
  val brighton = Address("Brighton", "UK")
  val tigger = Pet("Tigger", "Spaniel", 4)
  val miles = Person("Miles", brighton, tigger)

  val t1 = Node(Node(Leaf(1), Leaf(2)), Leaf(3))
  val t2 = Node(Leaf(4), Node(Leaf(5), Leaf(6)))
  val t3: Tree[Int] =
    Node(
      Node(
        Node(
          Leaf(1),
          Node(
            Leaf(2),
            Leaf(3)
          )
        ),
        Leaf(4)
      ),
      Node(
        Leaf(5),
        Leaf(6)
      )
    )
}

object Workshop extends App {
  import WorkshopDefns._


}
