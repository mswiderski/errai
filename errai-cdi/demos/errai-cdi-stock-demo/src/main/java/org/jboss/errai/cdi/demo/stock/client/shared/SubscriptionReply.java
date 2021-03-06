package org.jboss.errai.cdi.demo.stock.client.shared;

import java.util.List;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.enterprise.client.cdi.api.Conversational;

/**
 * Fired in response to a subscription request. Provides new subscribers with an initial snapshot of tick history.
 * 
 * @author Jonathan Fuerth <jfuerth@gmail.com>
 */
@Portable
@Conversational
public class SubscriptionReply {

  /**
   * The currently-cached information about each stock we're tracking, in the order they should be displayed in the user
   * interface.
   */
  private List<TickCache> tickHistories;

  public void setTickHistories(List<TickCache> tickHistories) {
    this.tickHistories = tickHistories;
  }

  public List<TickCache> getTickHistories() {
    return tickHistories;
  }
}
