package com.binsenteu.carburant.model.gasstation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E10")
public class E10 extends Fuel {

}
