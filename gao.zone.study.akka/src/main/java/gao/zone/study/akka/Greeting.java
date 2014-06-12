package gao.zone.study.akka;

import scala.Serializable;

public class Greeting implements Serializable {

	public final String who;

	public Greeting(String who) {
		this.who = who;
	}
	
	
}
