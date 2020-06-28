package com.binsenteu.carburant.model.gasstation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Gazole")
public class Gazole extends Fuel{

}
