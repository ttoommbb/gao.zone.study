package gao.zone.study.akka;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class GreetingActor extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	
	@Override
	public void onReceive(Object msg) throws Exception {
		if(msg instanceof Greeting) {
			log.info("Hello "+((Greeting)msg).who);
		}
	}

}
