/*
 * Open App Tray by clicking on the AppTray icon at the center
 * Click on Apps Tab
 * Click on Widgets Tab
 */

package com.linhnguyen.test;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class FirstAppTest extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException {
		// Get the device status
		UiDevice myDevice = getUiDevice();

		// If screen is off, wake up the device ( make sure the screen lock is
		// set to None
		if (!myDevice.isScreenOn()) {
			myDevice.wakeUp();
		}
		
		//Press Home button
		myDevice.pressHome();
		
		//Create UiObject instance for the UI element
		UiObject appTray = new UiObject(new UiSelector().description("Apps"));
		
		//Check if the AppTray exists
		if(appTray.exists()){
			appTray.clickAndWaitForNewWindow();
		}
	}

}
