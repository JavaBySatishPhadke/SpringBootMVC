package com.nt.model;

import lombok.Data;

@Data
public class Dancer {
   private  Integer  did;
   private   String name;
   private   String addrs="hyd";
   private   String danceForm;
   private  Float  fee;
   
   public   Dancer() {
	   System.out.println("Dancer:: 0-param constructor");
   }
   
}
