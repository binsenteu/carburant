package com.binsenteu.carburant.model.gasstation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GPLc")
public class GPLc extends Fuel {

}
