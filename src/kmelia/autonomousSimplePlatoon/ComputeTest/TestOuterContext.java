package kmelia.autonomousSimplePlatoon.ComputeTest;

import costo.kml2java.framework.ExecutableComponent;
import costo.kml2java.framework.ExecutionContext;
import costo.kml2java.framework.IService;
import costo.kml2java.framework.channels.Channel;

/**
 *  Minimal OuterContext
 * 
 *
 */
	public class TestOuterContext extends ExecutionContext{

		public TestOuterContext(String name) {
			super(name);
			
		}

		@Override
		public void closeChannel(ExecutableComponent executableComponent, IService clientservice, Channel chan) {
			//System.out.println("pretending to close outer  channel"+ chan);
		}
		
		
		
	}
