package net.mouluso.liverolehistory.model.factory;

import java.lang.reflect.Constructor;

import net.mouluso.liverolehistory.model.Action;

public class ActionFactory {
	public static Action newAction(String actionName){
		try {
			Class<?> card = Class.forName("net.mouluso.liverolehistory.model.actions." + actionName);
			Constructor<?> cardConstructor = card.getConstructor();
			return (Action) cardConstructor.newInstance(new Object[] {});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
