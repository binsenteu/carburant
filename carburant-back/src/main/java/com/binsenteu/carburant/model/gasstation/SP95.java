package com.binsenteu.carburant.model.gasstation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SP95")
public class SP95 extends Fuel {

}
