package kmelia.autonomousSimplePlatoon.testsM1IR;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import costo.kml2java.framework.IService;
import costo.kml2java.framework.channels.Channel;
import costo.kml2java.framework.channels.CommTypes;
import costo.kml2java.framework.channels.ExecutionBinding;
import costo.kml2java.framework.channels.IChannel;
import costo.kml2java.framework.channels.IChannelListener;
import costo.kml2java.framework.channels.ICommunication;
import costo.kml2java.framework.channels.SimpleCommunication;
//import costo.kml2java.framework.channels.Channel.SenderWaitingThread;
import costo.kml2java.framework.exceptions.KmlCommunicationException;

public class MockChannel extends Channel {

	class SenderWaitingThread extends Thread {

		// FIXME : add references in Channel to kill them if needed
		public SenderWaitingThread(IService sender, SynchronousQueue<ICommunication> queue, ICommunication comm, Channel chan, int commtype) {
			super();
			this.sender = sender;
			this.queue = queue;
			this.comm = comm;
			this.chan = chan;
			this.commtype = commtype;
		}

		IService sender;
		SynchronousQueue<ICommunication> queue;
		ICommunication comm;
		Channel chan;
		int commtype;

		@Override
		public void run() {
			try {
				chan.inc(queue);
				queue.put(comm);
				// FIXME test validity on a sync
				sender.ack(chan, commtype);
				chan.dec(queue);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	public String name;
	/**
	 * ExecutionBinding or Null is no owner
	 */
	public ExecutionBinding owner;
	public IService client;
	public IService server;

	// SynchronousQueue<ICommunication> syncqueue = new SynchronousQueue<ICommunication>(true);
	SynchronousQueue<ICommunication> emitToClient = new SynchronousQueue<ICommunication>(true);
	SynchronousQueue<ICommunication> emitToServer = new SynchronousQueue<ICommunication>(true);
	Integer emitToClientCounter =0;
	Integer emitToServerCounter =0;
	
	private ArrayList<IChannelListener> channelsListeners = new ArrayList<IChannelListener>();

	public MockChannel(String name, ExecutionBinding owner, IService client, IService server) {
		super(name, owner, client, server);
		this.name = name;
		this.owner = owner;
		this.client = client;
		this.server = server;
	}

	/**
	 * @param name
	 * @param client
	 * @param server
	 *            No owner
	 */
	public MockChannel(String name, IService client, IService server) {
		this(name, null, client, server);
	}

	/**
	 * @return the channel name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the channel name
	 */
	public String getLongName() {
		return this.getClass().getSimpleName() + "(" + this.getName() + ")";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (owner != null) {
			builder.append(owner.toString());
		}
		builder.append("\n-active on " + name + "\n");
		builder.append(", client=");
		builder.append(client);
		builder.append(", server=");
		builder.append(server);
		builder.append("]");
		return builder.toString();
	}

	public IService getPeer(IService onehand) {
		if (onehand == client)
			return (server);
		else
			return (client);
	}

	public void open() {
		// Subclass responsibility : start the server
		this.fireChannelEvent("Opening channel " + this.toString());
	}

	/**
	 * Normal end of communication (from required =client)
	 */
	public void close(IService source) {

		if (!emitToClient.isEmpty()) {
			// should be empty !!
			// Stop the processes, no direct access to 'waiting' so empty the queue
			ICommunication comm = null;
			try {
				comm = this.emitToClient.take();
				this.fireChannelErrorEvent(">> " + this.getLongName() + ": " + comm + " is removed from client queue");
				//System.err.println(">> " + this.getLongName() + ": " + comm + " is removed from client queue");
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		if (!emitToServer.isEmpty()) {
			// should be empty !!
			// Stop the processes, no direct access to 'waiting' so empty the queue
			ICommunication comm = null;
			try {
				comm = this.emitToServer.take();
				this.fireChannelErrorEvent(">> " + this.getLongName() + ": " + comm + " is removed from server queue");
				//System.err.println(">> " + this.getLongName() + ": " + comm + " is removed from server queue");
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		this.getPeer(source).eoc(this);

		// FIXME Stop the services but the problem is to avoid circles provide a parameter ?
		this.fireChannelEvent("Channel closed" + this.getName() + " with server counter "+emitToServerCounter+ " with client counter "+emitToClientCounter);
		//System.out.println("Channel closed" + this.getName() + " with server counter "+emitToServerCounter+ " with client counter "+emitToClientCounter);
	}

	/**
	 * Stop the processes
	 */
	public void cut(IService source) {

		if (!emitToClient.isEmpty()) {
			// should be empty !!
			// Stop the processes, no direct access to 'waiting' so empty the queue
			ICommunication comm = null;
			try {
				comm = this.emitToClient.take();
				this.fireChannelErrorEvent(">> " + this.getLongName() + ": " + comm + " is removed from client queue");
				//System.err.println(">> " + this.getLongName() + ": " + comm + " is removed from client queue");
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		if (!emitToServer.isEmpty()) {
			// should be empty !!
			// Stop the processes, no direct access to 'waiting' so empty the queue
			ICommunication comm = null;
			try {
				comm = this.emitToServer.take();
				this.fireChannelErrorEvent(">> " + this.getLongName() + ": " + comm + " is removed from server queue");
				//System.err.println(">> " + this.getLongName() + ": " + comm + " is removed from server queue");
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		this.getPeer(source).channelCut(this);
		// FIXME Stop the services but the problem is to avoid circles provide a parameter ?
		this.fireChannelEvent("Channel cut" + this.getName() + " with server counter "+emitToServerCounter+ " with client counter "+emitToClientCounter);
		//System.out.println("Channel cut" + this.getName() + " with server counter "+emitToServerCounter+ " with client counter "+emitToClientCounter);
	}

	/**
	 * @return ExecutionBinding or null if none
	 */
	public ExecutionBinding getOwner() {
		// Subclass responsibility
		return this.owner;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see costo.kml2java.framework.IChannel#callService(java.lang.String, java.lang.String, java.lang.Object[],
	 * costo.kml2java.framework.ExecutableService) to be refined in the subclass why the channels depends on the main service or a subservice
	 */
	@Override
	public void callService(String channel, String message, Object[] params, IService client) throws KmlCommunicationException {
		// channel is not used at this point because it is the sender point of view
		// __SELF / __CALLER / _required
		// not the receiver's point of view
		SimpleCommunication comm = new SimpleCommunication(message, params, channel, CommTypes.CALL);
		// starts the other service : should be done differently
		this.open();
		if (client == this.client) {
			SenderWaitingThread waiting = new SenderWaitingThread(client, emitToServer, comm, this, CommTypes.CALL);
			waiting.start();
			// FIXME collect these unaccessible threads
		} else
			throw new KmlCommunicationException(this, comm);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see costo.kml2java.framework.IChannel#returnService(java.lang.String, java.lang.String, java.lang.Object[],
	 * costo.kml2java.framework.ServiceAtExecution) FIXME : is-it the good place to stop the threads ?
	 */
	@Override
	public void returnService(String channel, String message, Object[] params, IService orig) {
		ICommunication comm = new SimpleCommunication(message, params, channel, CommTypes.EMIT_RESULT);

		SenderWaitingThread waiting = new SenderWaitingThread(orig, emitToClient, comm, this, CommTypes.EMIT_RESULT);
		waiting.start();
		// FIXME collect these unaccessible threads
	}

	@Override
	public void emitMessage(String channel, String message, Object[] params, IService orig) {
		ICommunication comm = new SimpleCommunication(message, params, channel, CommTypes.EMIT);
		SenderWaitingThread waiting = new SenderWaitingThread(orig, (orig == client ? emitToServer : emitToClient), comm, this, CommTypes.EMIT);
		// FIXME collect these unaccessible threads
		waiting.start();
	}

	// / RECEPTIONS
	@Override
	public Object[] receiveMessage(String channel, String message, Class<?>[] paramtypes, IService orig) {
		ICommunication comm = null;
		try {
			if (orig == client) {
				comm = this.emitToClient.take();
			} else {
				comm = this.emitToServer.take();
			}
			if (!compatibleComm(comm, channel, message, paramtypes, CommTypes.EMIT)) {
				this.fireChannelErrorEvent(">> " + this.getLongName() + ": " + comm + "\n incompatible with expected EMIT on " + "Channel=" + channel + " "
						+ message + " " + paramtypes + " type=" + CommTypes.EMIT);
				//System.err.println(">> " + this.getLongName() + ": " + comm + "\n incompatible with expected EMIT on " + "Channel=" + channel + " "
				//		+ message + " " + paramtypes + " type=" + CommTypes.EMIT);
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		// DO some test
		return comm.getMessageValues();
	}

	private boolean compatibleComm(ICommunication comm, String channel, String message, Class<?>[] paramtypes, Integer expectedcommtype) {
		// TODO : context mapping
		if (comm.getType() != expectedcommtype)
			return false;
		if (paramtypes.length != comm.getMessageValues().length)
			return false;
		if (this.getOwner() == null) {
			if (!message.equals(comm.getMessageName()))
				return false;
			else
				return true;
		} else
			return this.getOwner().messageMapping(channel, message, comm);
		// FIXME : should generate better diagnostic

	}

	@Override
	public Object[] receiveServiceCall(String channel, String message, Class<?>[] paramtypes, IService orig) {
		ICommunication comm = null;
		try {
			comm = this.emitToServer.take();
			if (!compatibleComm(comm, channel, message, paramtypes, CommTypes.CALL)) {
				this.fireChannelErrorEvent(">> " + this.getLongName() + ": " + comm + "\n incompatible with expected CALL on " + "Channel=" + channel + " "
						+ message + " " + paramtypes + " type=" + CommTypes.CALL);
				//System.err.println(">> " + this.getLongName() + ": " + comm + "\n incompatible with expected CALL on " + "Channel=" + channel + " "
				//		+ message + " " + paramtypes + " type=" + CommTypes.CALL);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// DO some test
		return comm.getMessageValues();
	}

	@Override
	public Object[] receiveServiceReturn(String channel, String message, Class<?>[] paramtypes, IService orig) {
		ICommunication comm = null;
		try {
			comm = this.emitToClient.take();
			if (!compatibleComm(comm, channel, message, paramtypes, CommTypes.EMIT_RESULT)) {
				this.fireChannelErrorEvent(">> " + this.getLongName() + ": " + comm + "\n incompatible with expected EMIT RESULT on " + "Channel=" + channel
					+ " " + message + " " + paramtypes + " type=" + CommTypes.EMIT_RESULT);
				//System.err.println(">> " + this.getLongName() + ": " + comm + "\n incompatible with expected EMIT RESULT on " + "Channel=" + channel
				//		+ " " + message + " " + paramtypes + " type=" + CommTypes.EMIT_RESULT);
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		// DO some test

		return comm.getMessageValues();
	}

	@Override
	public void addChannelListener(IChannelListener l) {
		this.channelsListeners.add(l);

	}

	@Override
	public void removeChannelListener(IChannelListener l) {
		this.channelsListeners.remove(l);

	}

	public void fireChannelEvent(String message) {
		for (IChannelListener lis : this.channelsListeners) {
			lis.channelEvolution(this, message);
		}
	}

	public void fireChannelErrorEvent(String message) {
		for (IChannelListener lis : this.channelsListeners) {
			lis.channelError(this, message);
		}
	}

	public void inc(SynchronousQueue<ICommunication> queue) {
		if (queue == emitToClient) emitToClientCounter++;
		else emitToServerCounter++;
	}

	public void dec(SynchronousQueue<ICommunication> queue) {
		if (queue == emitToClient) emitToClientCounter--;
		else emitToServerCounter--;
	}

}
