/*
 * SonarQube PHP Plugin
 * Copyright (C) 2010 SonarSource and Akram Ben Aissi
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.php.parser.expression;

import org.junit.Before;
import org.junit.Test;
import org.sonar.php.parser.PHPGrammar;
import org.sonar.php.parser.RuleTest;

public class SimpleEncapsVariableTest extends RuleTest {

  @Before
  public void setUp() {
    setTestedRule(PHPGrammar.SIMPLE_ENCAPS_VARIABLE);
  }

  @Test
  public void test() {
    matches("$variable");
    matches("$variable [ offset ]");
    matches("$variable -> identifier");

  }

  @Test
  public void test_real_life() {
    matches("$foo[0]");
    matches("$foo[0]");
    matches("$foo[identifier]");
    matches("$foo[$variable]");


  }

  @Test
  public void nok() throws Exception {
    notMatches("$var[test()]");
    notMatches("$var[{$test}]");
    notMatches("$var[$$test]");
  }

}
