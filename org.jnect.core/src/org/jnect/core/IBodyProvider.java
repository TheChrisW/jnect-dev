package org.jnect.core;

import org.jnect.bodymodel.Body;
import org.jnect.bodymodel.BodyHolder;

public interface IBodyProvider {

	public Body getBody();
	
	public BodyHolder getBodyHolder();

	/**
	 * Toggles the recording state.
	 * 
	 * @param on if true, recording is activated. It is deactivated otherwise.
	 */
	public void startStopRecoring(boolean on);

	/**
	 * @return true if the body is currently recorded, false otherwise
	 */
	public boolean isRecording();
}
