package com.example.grafy;

import com.vaadin.Application;
import com.vaadin.ui.*;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;

@SuppressWarnings("serial")
class ComboBoxInputPromptExample extends VerticalLayout implements
        Property.ValueChangeListener {

    private static final String[] cities = new String[] { "Berlin", "Brussels",
            "Helsinki", "Madrid", "Oslo", "Paris", "Stockholm" };

    public ComboBoxInputPromptExample() {
        setMargin(true, false, false, false); // for looks: more 'air'

        // Create & set input prompt
        ComboBox l = new ComboBox();
        l.setInputPrompt("Please select a city");

        // configure & load content
        l.setImmediate(true);
        l.addListener(this);
        for (int i = 0; i < cities.length; i++) {
            l.addItem(cities[i]);
        }

        // add to the layout
        addComponent(l);
    }

    /*
     * Shows a notification when a selection is made.
     */
    public void valueChange(ValueChangeEvent event) {
        getWindow().showNotification("Selected city: " + event.getProperty());

    }
}

@SuppressWarnings("serial")
public class GrafyApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Grafy Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		mainWindow.addComponent( new ComboBoxInputPromptExample() );
		setMainWindow(mainWindow);
	}

}



