import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {
/*
 * @param Buttons for calculator project, created with SceneBuilder
 */
    @FXML
    private Button digit8;
    @FXML
    private Button digit7;
    @FXML
    private Button digit9;
    @FXML
    private Button digit5;
    @FXML
    private Button digit4;
    @FXML
    private Button digit6;
    @FXML
    private Button digit2;
    @FXML
    private Button digit1;
    @FXML
    private Button digit3;
    @FXML
    private Button digit0;
    @FXML
    private Button period;
    
    @FXML
    //parentheses
    private Button rightParent;
    @FXML
    //parentheses
    private Button leftParent;
    
    @FXML
    private Button multiply;
    @FXML
    private Button subtract;
    @FXML
    private Button plus;
    @FXML
    private Button equals;
    @FXML
    private Button divide;

    @FXML
    private Button backspace;
    @FXML
    private Button clear;
    @FXML
    private Button clearALL;

    @FXML
    private Button reversePositive;
    @FXML
    private Button nButton;
    @FXML
    private Button pie;
    @FXML
    private Button second;
    @FXML
    private Button exp;
    @FXML
    private Button log;
    @FXML
    private Button EXPx;
    @FXML
    private Button tan;

    @FXML
    private Button cos;
    @FXML
    private Button sin;
    @FXML
    private Button EXPY;
    @FXML
    private Button EXP2;
    @FXML
    private Button memoryClear;
    @FXML
    private Button MemoryRecall;
    @FXML
    private Button MemoryPlus;
    @FXML
    private Button MemoryMinus;
    @FXML
    private Button MemoryStore;
    @FXML
    private Label outputLabel;
    
    
    /*************************************************************************************************************************/
   
    
    /**
     * To-Do's? :
     * 
     * 
     * 
     * -Change outputLabel to a textBox for "Keyboard filtering" -- Or don't it's probably not even 1 point
     * 
     * -Memory File probably -- Maybe just through auto-generated strings into a txt file, maybe implement data retrieval into the outputLabel? 
     * 
     * -I think i probably forgot the Period button
     * 
     * @author jstru
     *
     */
    
    
    /*
     * @param calculator class for processing calculations
     */
    class Calculator{
    	
    	private
    	
    	double firstInput, secondInput;
    	char operator;
    	
    	
    	public
    	
    	//void display() {outputLabel.setText(value);  ***Determine necessity***
    	
    	Calculator() {
    		
    		firstInput = 0;
    		secondInput = 0;
    		operator = ' ';
    		
    	}
    	
    	void setFirstInput(double firstInput) {
    		
    		if(this.firstInput != 0) {this.setSecondInput(firstInput);}
    		else{this.firstInput = firstInput;}
    		
    		}
    	
    	void setSecondInput(double secondInput) {
    		this.secondInput = secondInput;
    		}
    	
    	void setoperator(char operator) {
    		this.operator = operator;
    		}
    	
    	
    	// clear input
    	void clearAll() {firstInput=0; secondInput=0; operator = ' '; outputLabel.setText("");}
    	
    	double simpleCalculate() {
    		
    		double output = 0;
    		/*
    		 * @param case to see which operator is used
    		 * @return answer to equation
    		 */
    		switch(operator) {
    		case '+': output = firstInput + secondInput; break;
    		case '-': output = firstInput - secondInput; break;
    		case '/': output = firstInput / secondInput; break;
    		case '*': output = firstInput * secondInput; break;
    		case '^': output = Math.pow(firstInput, secondInput); break;
    		}
			
    		secondInput = 0;
    		firstInput=output;
    		return output;
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    }
    
    
    
    Calculator calc = new Calculator();
    
    Stack memory = new Stack();
    
    /*************************************************************************************************************************/


    /*
     * @param clear action to clear output
     * @blank string
     */
    @FXML
    void ActionClear(ActionEvent event) {

    	outputLabel.setText("");
    	
    }
/*
 * @param clear all 
 * @return blank string
 */
    @FXML
    void ActionClearAll(ActionEvent event) {
    	calc.clearAll();
    	//Call the clearAll function instead
    }

    /*
     * @param equals button to signal typing is done
     * @return answer to equation 
     */
    @FXML
    void ActionEquals(ActionEvent event) {
    	calc.setFirstInput(Double.parseDouble(outputLabel.getText()));
    	outputLabel.setText("" + calc.simpleCalculate());
    }


    

    /*
     * exponent button
     * @return x^x
     */
    @FXML
    void ActionExp(ActionEvent event) {
    	outputLabel.setText("" + Math.expm1(Double.parseDouble(outputLabel.getText())));
    }

    // List for memory 
	List<Integer> list = new ArrayList<Integer>();
    /*
     * @param clear memory
     */
	
	@FXML
    void ActionMemoryClear(ActionEvent event) {
    	list.clear();
    	
    	}
/*
 * @param minus outputLabel from recent memory variable
 */
    @FXML
    void ActionMemoryMinus(ActionEvent event) {
    	int test = list.get(list.size() -1);
    	int a = Integer.valueOf(outputLabel.getText());
    	int b = (a - test);
    	outputLabel.setText("" + b);
    }
/*
 * @param plus outputLabel from recent memory variable
 */
    @FXML
    void ActionMemoryPlus(ActionEvent event) {
    	int test = list.get(list.size() -1);
    	int a = Integer.valueOf(outputLabel.getText());
    	int b = (a + test);
    	outputLabel.setText("" + b);
    }
/*
 * @param return last stored int
 * @return last stored int
 */
    @FXML
    void ActionMemoryRecall(ActionEvent event) {
    	int test = list.get(list.size() -1);
    	outputLabel.setText("" + test);
    }
/*
 * @param add outputLabel to ArrayList
 */
    @FXML
    void ActionMemoryStore(ActionEvent event) {

    	list.add(Integer.valueOf(outputLabel.getText()));
    	//int a = Integer.valueOf(outputLabel.getText());
    	
    	/*
    	
    	
    	for (int i = 0; i < 10; i++) {
    		memoryArr[i] = Integer.valueOf(outputLabel.getText());
    		}
    		*/
    	}


    @FXML
    /*
     * @param reverse the sign of the number input
     * @return number input with sign changed
     */
    void ActionReverseSign(ActionEvent event) {
    	double x = Double.parseDouble(outputLabel.getText());
    
    	if(x>=0) {outputLabel.setText("" + (x - x - x));}
    	else {outputLabel.setText("" + Math.abs(x));}
    }

    @FXML
    void ActionSecond(ActionEvent event) {
    	
    }
    
    
    
    /*************************************************************************************************************************/
    
    @FXML
    /*
     * @param backspace output
     * @return when button pressed, output string length -1 
     */
    void ActionBackspace(ActionEvent event) {

    	String workSpace = outputLabel.getText();
    	
    	workSpace = workSpace.substring(0, workSpace.length()-1);
    	
    	outputLabel.setText(workSpace);
    	
    }
    /*
     * @param exponent function
     * @return x ^2 
     */
    @FXML
    void ActionExponentTwo(ActionEvent event) {

    	double x = Double.parseDouble(outputLabel.getText());
    	
    	outputLabel.setText("" + x * x  );
    	
    }
    @FXML
    /*
     * @param exponent by x 
     * @return x ^ y
     */
    void ActionExpX(ActionEvent event) {

    	outputLabel.setText("" + Math.pow(10, Double.parseDouble(outputLabel.getText())));
    	
    }
    @FXML
    /*
     * @param log function
     * @return log(x)
     */
    void ActionLog(ActionEvent event) {

    	double x = Double.parseDouble(outputLabel.getText());
    	
    	outputLabel.setText("" + Math.log(x)  );
    }
    /*
     * @param pie function
     * @return 3.14.....
     */
    @FXML
    void ActionPie(ActionEvent event) {
    	double x = Double.parseDouble(outputLabel.getText());
    	outputLabel.setText("" + Math.PI * x);
    }
    
    @FXML
    /*
     * @param factorial function
     * @return x * i
     */
    void factorialCalculate(ActionEvent event) {

    	double x = Double.parseDouble(outputLabel.getText());
    	double output=1;
    	
    	for(int i = 1; i<=x; i++) {
    		output = output * i;
    	}
    	
    	outputLabel.setText("" + output);
    }
    
    /*************************************************************************************************************************/
    /*
     * @param sin function
     * @return sin(x)
     */
    @FXML
    void ActionSin(ActionEvent event) {
    	double x = Double.parseDouble(outputLabel.getText());
    	outputLabel.setText("" + Math.sin(x));
    }

    /*
     * @param tan function
     * @return tan(x)
     */
    @FXML
    void ActionTan(ActionEvent event) {
    	double x = Double.parseDouble(outputLabel.getText());
    	outputLabel.setText("" + Math.tan(x));
    }
    
    /*
     * @param cos function
     * @return cos(x)
     */
    @FXML
    void ActionCos(ActionEvent event) {
    	double x = Double.parseDouble(outputLabel.getText());
    	outputLabel.setText("" + Math.cos(x));
    }
    
    
    /*************************************************************************************************************************/ 
    /*
     * @param multiply function
     * @return x * y
     */
    @FXML
    void ActionMultipy(ActionEvent event) {
    	calc.setoperator('*');
    	calc.setFirstInput(Double.parseDouble(outputLabel.getText()));
    	outputLabel.setText("");
    	//outputLabel.setText(outputLabel.getText() + " * ");
    }
    /*
     * @param substraction
     * @return x - y
     */
    @FXML
    void ActionSubtract(ActionEvent event) {
    	calc.setoperator('-');
    	calc.setFirstInput(Double.parseDouble(outputLabel.getText()));
    	outputLabel.setText("");
    	//outputLabel.setText(outputLabel.getText() + " - ");
    }
    /*
     * @param plus function
     * @return x + y
     */
    @FXML
    void ActionPlus(ActionEvent event) {
    	calc.setoperator('+');
    	calc.setFirstInput(Double.parseDouble(outputLabel.getText()));
    	outputLabel.setText("");
    	//outputLabel.setText(outputLabel.getText() + " + ");
    }
    /*
     * @param divide function
     * @return x / y
     */
    @FXML
    void ActionDivide(ActionEvent event) {
    	calc.setoperator('/');
    	calc.setFirstInput(Double.parseDouble(outputLabel.getText()));
    	outputLabel.setText("");
    }
    	//outputLabel.setText(outputLabel.getText() + " / ");
    /*
     * @param exponent
     * @return x ^ y
     */
    @FXML
    void ActionExY(ActionEvent event) {
    	calc.setoperator('^');
    	calc.setFirstInput(Double.parseDouble(outputLabel.getText()));
    	outputLabel.setText("");
    	//firstInput = Integer.parseInt(outputLabel.getText());
    	//operand = '^';
    }
    /*************************************************************************************************************************/
    
    /*
     * @param action events for digits
     * @return selected digit
     */
    @FXML
    void actionEight(ActionEvent event) { outputLabel.setText(outputLabel.getText() + "8"); }
    @FXML
    void actionFive(ActionEvent event) { outputLabel.setText(outputLabel.getText() + "5"); }
    @FXML
    void actionFour(ActionEvent event) {outputLabel.setText(outputLabel.getText() + "4");}
    @FXML
    void actionNine(ActionEvent event) {outputLabel.setText(outputLabel.getText() + "9");}
    @FXML
    void actionOne(ActionEvent event) {outputLabel.setText(outputLabel.getText() + "1");}
    @FXML
    void actionSeven(ActionEvent event) {outputLabel.setText(outputLabel.getText() + "7");}
    @FXML
    void actionSix(ActionEvent event) {outputLabel.setText(outputLabel.getText() + "6");}
    @FXML
    void actionThree(ActionEvent event) {outputLabel.setText(outputLabel.getText() + "3");}
    @FXML
    void actionTwo(ActionEvent event) {outputLabel.setText(outputLabel.getText() + "2");}
    @FXML
    void actionZero(ActionEvent event) {outputLabel.setText(outputLabel.getText() + "0");}
    @FXML
    void actionPeriod(ActionEvent event) {outputLabel.setText(outputLabel.getText() + ".");}
    
    
    
    
}
