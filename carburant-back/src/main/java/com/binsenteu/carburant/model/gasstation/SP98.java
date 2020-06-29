package com.binsenteu.carburant.model.gasstation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SP98")
public class SP98 extends Fuel {

}
