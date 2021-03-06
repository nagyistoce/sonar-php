<?php

class A {

  private function __construct() {  // OK - private constructor
  }

  private function f() {            // NOK
    $foo = clone $this;

    $code = '_i';
    echo "${foo->j()}";
    return $foo->g(1)
               ->h();
  }

  private function g($p1) {         // OK
  }

  private function h() {            // OK
  }

  private function _i() {           // OK - used in a simple string literal
  }

  private function j() {            // OK - used as encapsulated variable in string
  }

  public function k() {             // OK - public
  }

}

class B {

  private $field;

  private function B() {              // OK - private constructor
  }


}
