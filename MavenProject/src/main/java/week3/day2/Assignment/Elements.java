package week3.day2.Assignment;

public class Elements extends Button {

	public static void main(String[] args) {

		Elements element = new Elements();
		// Button Class
		element.click();

		// WebElement Class
		element.setText();
		element.sumbit();

		// RadioButton
		RadioButton radioButton = new RadioButton();
		radioButton.click();
		radioButton.selectRadioButton();
		radioButton.sumbit();
		radioButton.setText();

		// CheckboxButton
		CheckBoxButton checkboxButton = new CheckBoxButton();
		checkboxButton.click();
		checkboxButton.sumbit();
		checkboxButton.setText();
		
		//TextField
		TextField textField = new TextField();
		textField.click();
		textField.getText();
		textField.setText();
	}
}
