package LLD.designpatterns.abstractfactorydesignpattern;

// 1. Abstract Product Interfaces
// These interfaces define the common methods for all products (e.g., Button, Textbox).

interface Button {
    void render();  // Method to render the button
}

interface Textbox {
    void render();  // Method to render the textbox
}


// 2. Concrete Product Classes
// These are specific implementations of the Abstract Product interfaces.

class LightButton implements Button {
    public void render() {
        System.out.println("Rendering Light Button");
    }
}

class DarkButton implements Button {
    public void render() {
        System.out.println("Rendering Dark Button");
    }
}

class LightTextbox implements Textbox {
    public void render() {
        System.out.println("Rendering Light Textbox");
    }
}

class DarkTextbox implements Textbox {
    public void render() {
        System.out.println("Rendering Dark Textbox");
    }
}

// 3. Abstract Factory Interface
// This defines the abstract methods for creating related products (Button and Textbox).

interface UIFactory {
    Button createButton();  // Method to create a Button
    Textbox createTextbox();  // Method to create a Textbox
}


// 4. Concrete Factories
// These classes implement the UIFactory and return concrete product instances.

class LightFactory implements UIFactory {
    public Button createButton() {
        return new LightButton();  // Return a LightButton
    }

    public Textbox createTextbox() {
        return new LightTextbox();  // Return a LightTextbox
    }
}

class DarkFactory implements UIFactory {
    public Button createButton() {
        return new DarkButton();  // Return a DarkButton
    }

    public Textbox createTextbox() {
        return new DarkTextbox();  // Return a DarkTextbox
    }
}
// 5. Client Class
// The client uses the factory to get products and render them. It does not know about concrete classes.

class UIClient {
    private Button button;  // Declare a Button variable
    private Textbox textbox;  // Declare a Textbox variable

    // Constructor takes a UIFactory, so it can create related products.
    public UIClient(UIFactory factory) {
        button = factory.createButton();  // Use factory to create Button
        textbox = factory.createTextbox();  // Use factory to create Textbox
    }

    // Method to render the UI
    public void render() {
        button.render();  // Render the button
        textbox.render();  // Render the textbox
    }
}


// 6. Main Method
// The entry point to the program where we create the factory and client to render the UI.

public class AbstractFactoryExample {
    public static void main(String[] args) {
        // Select the factory (switch between LightFactory and DarkFactory easily)
        UIFactory factory = new DarkFactory();  // You can switch to LightFactory() for Light theme

        // Create a client passing the factory to the constructor
        UIClient client = new UIClient(factory);

        // Render the UI
        client.render();  // This will render the products created by the factory
    }
}
