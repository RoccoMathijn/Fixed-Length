package com.github.atais.read

import com.github.atais.util.Read._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class ReadersTest extends AnyFlatSpec with Matchers with ScalaCheckPropertyChecks {

  implicit val generatorDrivenConf = PropertyCheckConfiguration(minSuccessful = 5000)

  "Any short" should "be parsed properly" in {
    forAll { m: Short => test(shortRead.read(m.toString), m) }
  }

  "Any int" should "be parsed properly" in {
    forAll { m: Int => test(intRead.read(m.toString), m) }
  }

  "Any long" should "be parsed properly" in {
    forAll { m: Long => test(longRead.read(m.toString), m) }
  }

  "Any float" should "be parsed properly" in {
    forAll { m: Float => test(floatRead.read(m.toString), m) }
  }

  "Any double" should "be parsed properly" in {
    forAll { m: Double => test(doubleRead.read(m.toString), m) }
  }

  "Any boolean" should "be parsed properly" in {
    forAll { m: Boolean => test(booleanRead.read(m.toString), m) }
  }

  "Any char" should "be parsed properly" in {
    forAll { m: Char => test(charRead.read(m.toString), m) }
  }

  "Any string" should "be parsed properly" in {
    forAll { m: String => test(stringRead.read(m), m) }
  }

  private def test[A](returned: Either[Throwable, A], checkValue: A) = {
    returned match {
      case Right(v) => v shouldEqual checkValue
      case Left(_) => fail()
    }
  }

}
