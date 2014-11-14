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
import com.android.uiautomator.core.UiScrollable;
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

		// Press Home button
		myDevice.pressHome();

		// Create UiObject instance for the UI element
		UiObject appTray = new UiObject(new UiSelector().description("Apps"));

		// Check if the AppTray exists
		if (appTray.exists()) {
			appTray.clickAndWaitForNewWindow();
		}

		UiObject appTab = new UiObject(new UiSelector()
				.className("android.widget.TextView").description("Apps")
				.text("Apps"));
		if (appTab.exists()) {
			appTab.click();
		}
		// Scrollable = false
		UiScrollable findApp = new UiScrollable(new UiSelector()
				.className("android.view.View")
				.packageName("com.motorola.motlauncher").scrollable(true));
		findApp.setAsHorizontalList();

		UiObject settingsApp = findApp.getChildByText(new UiSelector()
				.className(android.widget.TextView.class.getName())
				.packageName("com.motorola.motlauncher"), "FileString", true);

		if (settingsApp.exists()) {
			settingsApp.click();
		}

		UiObject appMenu = new UiObject(
				new UiSelector()
						.className("android.widget.TextView")
						.description("Add")
						.resourceId(
								"com.filestring.lattedouble:id/menu_files_list_action_add"));
		if (appMenu.exists()) {
			appMenu.click();
		}
		UiObject appString = new UiObject(new UiSelector()
				.className("android.widget.TextView").text("String a File")
				.resourceId("com.filestring.lattedouble:id/string_file"));
		if (appString.exists()) {
			appString.click();
		}

		UiObject fileManager = new UiObject(new UiSelector()
				.className("android.widget.TextView").text("File Manager")
				.resourceId("com.filestring.lattedouble:id/source_title"));
		if (fileManager.exists()) {
			fileManager.click();
		}

		UiScrollable findFolder = new UiScrollable(new UiSelector()
				.className("android.widget.ListView")
				.packageName("com.rhmsoft.fm").scrollable(true));

		findApp.setAsVerticalList();

		UiObject data = findFolder.getChildByText(
				new UiSelector().resourceId("com.rhmsoft.fm:id/name")
						.className("android.widget.TextView")
						.packageName("com.rhmsoft.fm"), "data", true);
		if (data.exists()) {
			data.click();
		}
		UiObject fileName = new UiObject(new UiSelector()
				.className("android.widget.TextView")
				.text("PL_09_Presentation_skill - VN.pptx")
				.resourceId("com.rhmsoft.fm:id/name")
				.packageName("com.rhmsoft.fm"));
		if (fileName.exists()) {
			fileName.click();
		}

		UiObject emailEditText = new UiObject(
				new UiSelector()
						.className("android.widget.EditText")
						.packageName("com.filestring.lattedouble")
						.resourceId(
								"com.filestring.lattedouble:id/auto_text_add_recipient")
						.text("Type Names or Email Addresses"));
		if (emailEditText.exists()) {
			emailEditText.click();
			emailEditText.setText("sta001@yopmail.com");
		}

		UiObject sendStringFile = new UiObject(new UiSelector()
				.className("android.widget.TextView")
				.text("Send")
				.resourceId(
						"com.filestring.lattedouble:id/menu_recipients_send")
				.packageName("com.filestring.lattedouble"));
		if (sendStringFile.exists()) {
			sendStringFile.click();
		}
		// Validate that the package name is the expected one
		// UiObject settingsValidation = new UiObject(
		// new UiSelector().packageName("com.android.settings"));
		// assertTrue("Unable to detect Settings", settingsValidation.exists());
	}

}
