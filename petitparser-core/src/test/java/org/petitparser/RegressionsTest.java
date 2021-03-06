package org.petitparser;

import static org.petitparser.Assertions.assertSuccess;
import static org.petitparser.parser.primitive.CharacterParser.of;

import org.junit.Test;
import org.petitparser.parser.Parser;

/**
 * Various regressions amd tricky examples.
 */
public class RegressionsTest {

  @Test
  public void testFlattenTrim() {
    Parser parser = of('a').flatten().trim();
    assertSuccess(parser, "a", "a");
    assertSuccess(parser, " a ", "a");
    assertSuccess(parser, "  a  ", "a");
  }

  @Test
  public void testTrimFlatten() {
    Parser parser = of('a').trim().flatten();
    assertSuccess(parser, "a", "a");
    assertSuccess(parser, " a ", " a ");
    assertSuccess(parser, "  a  ", "  a  ");
  }
}
