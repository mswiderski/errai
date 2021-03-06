package org.jboss.errai.ui.rebind.chain;

import org.jboss.errai.ui.shared.chain.Chain;
import org.jboss.errai.ui.shared.chain.Command;
import org.jboss.errai.ui.shared.chain.Context;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author edewit@redhat.com
 */
public class TemplateCatalogTest {

  @Test
  public void shouldHaveAutomatedSetup() {
    // given
    final DummyCommand command = new DummyCommand();
    final TemplateCatalog catalog = TemplateCatalog.createTemplateCatalog(command);

    // when
    final URL template = getClass().getResource("/simple.html");
    catalog.visitTemplate(template);

    // then
    final Chain chain = catalog.getChain();
    assertEquals(1, chain.getCommands().size());
    assertEquals(5, command.getCounter());
    assertNotNull(catalog.getResult(template, "dummy"));
  }

  public static class DummyCommand implements Command {
    private int counter;

    @Override
    public void execute(Context context) {
      assertNotNull(context.get(TemplateCatalog.ELEMENT));
      context.put("dummy", new Object());
      counter++;
    }

    @Override
    public Context createInitialContext() {
      return new Context();
    }

    public int getCounter() {
      return counter;
    }
  }
}
