package org.jboss.errai.demo.grocery.client.local;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.google.gwt.gen2.picker.client.SliderBar;

/**
 * @author edewit@redhat.com
 */
@ApplicationScoped
public class SliderBarProducer {

  @Produces
  public SliderBar createSliderBar() {
    SliderBar sliderBar = new SliderBar(50, 2000);
    sliderBar.setStepSize(20);
    sliderBar.setCurrentValue(100);
    sliderBar.setNumTicks(20);
    return sliderBar;
  }
}
