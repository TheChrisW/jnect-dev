/*******************************************************************************
 * Copyright (c) 2012 jnect.org.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eugen Neufeld - initial API and implementation
 *******************************************************************************/
package org.jnect.core.impl;

import java.util.logging.Logger;

import org.jnect.bodymodel.BodyHolder;
import org.jnect.bodymodel.PositionedElement;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SkeletonParser {
	
	public static final String SKELETON_KEYWORD = "skeletonData";
	
	private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	private BodyHolder bodyHolder;
	
	private int oldNumSkeletons = -1;
	private int frame = -1;


	public SkeletonParser(BodyHolder bodyHolder) {
		this.bodyHolder = bodyHolder;
	}
	
	public void reset() {
		this.oldNumSkeletons = -1;
		this.frame = -1;
	}
	
	public void parseSkeleton(Document doc) {
		NodeList frameNodes = doc.getElementsByTagName("frameNumber");
		// TODO Possible NPE if document is invalid
		Node frameNode = frameNodes.item(0);
		int currentFrame = Integer.parseInt(frameNode.getTextContent());
		if (currentFrame > this.frame) { // TODO I receive the same document multiple times
			this.frame = currentFrame;
			NodeList skeletons = doc.getElementsByTagName(SKELETON_KEYWORD);
			
			// Check whether number of skeletons has changed
			if (skeletons.getLength() != oldNumSkeletons) {
				oldNumSkeletons = skeletons.getLength();
				logger.info("Found " + skeletons.getLength() + " skeletons");
			}
			
			for (int i = 0; i < skeletons.getLength(); i++) {
				Node skeleton = skeletons.item(i);
				NodeList skeletonData = skeleton.getChildNodes();
				
				for (int j = 0; j < skeletonData.getLength(); j++) {
					Node data = skeletonData.item(j);
					
					if (data.getNodeName().equals("joint")) {
						Joint joint = parseJoint(data, i);
						updateModel(joint);
					}
				}
			}
		}
	}

	private Joint parseJoint(Node jointNode, int numSkeleton) {
		Joint joint = new Joint();
		
		NodeList data = jointNode.getChildNodes();
		for (int k = 0; k < data.getLength(); k++) {
			Node jointData = data.item(k);
			if (jointData.getNodeName().equals("jointId")) {
				String jointId = jointData.getTextContent();
				joint.part = getPositionedElement(jointId, numSkeleton);
				
			} else if (jointData.getNodeName().equals("positionX")) {
				String posX = jointData.getTextContent().replace(',', '.');
				joint.positionX = Float.parseFloat(posX);
			} else if (jointData.getNodeName().equals("positionY")) {
				String posY = jointData.getTextContent().replace(',', '.');
				joint.positionY = Float.parseFloat(posY);
			} else if (jointData.getNodeName().equals("positionZ")) {
				String posZ = jointData.getTextContent().replace(',', '.');
				joint.positionZ = Float.parseFloat(posZ);
			}
		}
		
		return joint;
	}
	
	private PositionedElement getPositionedElement(String jointId, int numSkeleton) {
		if (jointId.equals("Head")) {
			return bodyHolder.getBodies().get(numSkeleton).getHead();
		} else if (jointId.equals("HipCenter")) {
			return bodyHolder.getBodies().get(numSkeleton).getCenterHip();
		} else if (jointId.equals("Spine")) {
			return bodyHolder.getBodies().get(numSkeleton).getSpine();
		}  else if (jointId.equals("ShoulderCenter")) {
			return bodyHolder.getBodies().get(numSkeleton).getCenterShoulder();
		} else if (jointId.equals("ShoulderLeft")) {
			return bodyHolder.getBodies().get(numSkeleton).getLeftShoulder();
		} else if (jointId.equals("ElbowLeft")) {
			return bodyHolder.getBodies().get(numSkeleton).getLeftElbow();
		} else if (jointId.equals("WristLeft")) {
			return bodyHolder.getBodies().get(numSkeleton).getLeftWrist();
		} else if (jointId.equals("HandLeft")) {
			return bodyHolder.getBodies().get(numSkeleton).getLeftHand();
		} else if (jointId.equals("ShoulderRight")) {
			return bodyHolder.getBodies().get(numSkeleton).getRightShoulder();
		} else if (jointId.equals("ElbowRight")) {
			return bodyHolder.getBodies().get(numSkeleton).getRightElbow();
		} else if (jointId.equals("WristRight")) {
			return bodyHolder.getBodies().get(numSkeleton).getRightWrist();
		} else if (jointId.equals("HandRight")) {
			return bodyHolder.getBodies().get(numSkeleton).getRightHand();
		} else if (jointId.equals("HipLeft")) {
			return bodyHolder.getBodies().get(numSkeleton).getLeftHip();
		} else if (jointId.equals("KneeLeft")) {
			return bodyHolder.getBodies().get(numSkeleton).getLeftKnee();
		} else if (jointId.equals("AnkleLeft")) {
			return bodyHolder.getBodies().get(numSkeleton).getLeftAnkle();
		} else if (jointId.equals("FootLeft")) {
			return bodyHolder.getBodies().get(numSkeleton).getLeftFoot();
		} else if (jointId.equals("HipRight")) {
			return bodyHolder.getBodies().get(numSkeleton).getRightHip();
		} else if (jointId.equals("KneeRight")) {
			return bodyHolder.getBodies().get(numSkeleton).getRightKnee();
		} else if (jointId.equals("AnkleRight")) {
			return bodyHolder.getBodies().get(numSkeleton).getRightAnkle();
		} else if (jointId.equals("FootRight")) {
			return bodyHolder.getBodies().get(numSkeleton).getRightFoot();
		}
		
		// TODO Throw proper Exception here
		return null;
	}

	private void updateModel(Joint joint) {
		joint.part.setX(joint.positionX);
		joint.part.setY(joint.positionY);
		joint.part.setZ(joint.positionZ);
	}
	
	private class Joint {
		private float positionX;
		private float positionY;
		private float positionZ;
		private PositionedElement part;
	}
	/*
	private static HumanBodyEnum getHumanPart(String jointId) {
		// TODO Use proper names in XML. Needs to be fixed in C/C#-Code.
		// return HumanBodyEnum.valueOf(jointId);
		if (jointId.equals("Head")) {
			return HumanBodyEnum.Head;
		} else if (jointId.equals("HipCenter")) {
			return HumanBodyEnum.Hip_Center;
		} else if (jointId.equals("Spine")) {
			return HumanBodyEnum.Spine;
		}  else if (jointId.equals("ShoulderCenter")) {
			return HumanBodyEnum.Shoulder_Center;
		} else if (jointId.equals("ShoulderLeft")) {
			return HumanBodyEnum.Shoulder_Left;
		} else if (jointId.equals("ElbowLeft")) {
			return HumanBodyEnum.Elbow_Left;
		} else if (jointId.equals("WristLeft")) {
			return HumanBodyEnum.Wrist_Left;
		} else if (jointId.equals("HandLeft")) {
			return HumanBodyEnum.Hand_Left;
		} else if (jointId.equals("ShoulderRight")) {
			return HumanBodyEnum.Shoulder_Right;
		} else if (jointId.equals("ElbowRight")) {
			return HumanBodyEnum.Elbow_Right;
		} else if (jointId.equals("WristRight")) {
			return HumanBodyEnum.Wrist_Right;
		} else if (jointId.equals("HandRight")) {
			return HumanBodyEnum.Hand_Right;
		} else if (jointId.equals("HipLeft")) {
			return HumanBodyEnum.Hip_Left;
		} else if (jointId.equals("KneeLeft")) {
			return HumanBodyEnum.Knee_Left;
		} else if (jointId.equals("AnkleLeft")) {
			return HumanBodyEnum.Ankle_Left;
		} else if (jointId.equals("FootLeft")) {
			return HumanBodyEnum.Foot_Left;
		} else if (jointId.equals("HipRight")) {
			return HumanBodyEnum.Hip_Right;
		} else if (jointId.equals("KneeRight")) {
			return HumanBodyEnum.Knee_Right;
		} else if (jointId.equals("AnkleRight")) {
			return HumanBodyEnum.Ankle_Right;
		} else if (jointId.equals("FootRight")) {
			return HumanBodyEnum.Foot_Right;
		}
		
		// TODO Throw proper Exception here
		return null;
	}
*/
}
