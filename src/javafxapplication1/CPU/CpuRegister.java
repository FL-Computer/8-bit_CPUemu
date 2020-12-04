/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.CPU;

import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import static javafxapplication1.CPU.ControlUnit.getInstructionAsString;
import static javafxapplication1.CPU.ControlUnit.getOpcode;

/**
 *
 * @author Jorge
 */
public class CpuRegister extends Register{
    private Rectangle rectangle;
    private Label contentLabel;
    private NumberingSystem content_numberingSystem;
    
    
    public CpuRegister(){
        super();
    }
    
    //Setea los componentes que representan al registro en la GUI
    public void setGUI(Label label, Rectangle rectangle){
        this.contentLabel = label;
        this.rectangle = rectangle;
        this.content_numberingSystem = NumberingSystem.BIN;
    }
    
    //Resalta el registro instanciado (THIS) en la GUI 
    public void setHighlight(Boolean bool){
        if(bool){
            rectangle.setVisible(false);
        }else{
            rectangle.setVisible(true);
        }
    }
    
    public void swapBase(){
        if(this.content_numberingSystem == NumberingSystem.BIN){
            this.content_numberingSystem = NumberingSystem.DEC;
        }else if(this.content_numberingSystem == NumberingSystem.DEC){
            this.content_numberingSystem = NumberingSystem.BIN;
        }
    }
    
    public void swapInstBase(){
        if(null != this.content_numberingSystem)switch (this.content_numberingSystem) {
            case BIN:
                this.content_numberingSystem = NumberingSystem.OPCbin;
                break;
            case OPCbin:
                this.content_numberingSystem = NumberingSystem.OPCdec;
                break;
            case OPCdec:
                this.content_numberingSystem = NumberingSystem.BIN;
                break;
            default:
                break;
        }
    }
    
    //Intercambia el formato del contenido del registro en la GUI
    public void update(){
        if(this.content_numberingSystem == NumberingSystem.BIN){
            this.contentLabel.setText(this.getBinaryValueAsString());
        }else if(this.content_numberingSystem == NumberingSystem.OPCbin){
            this.contentLabel.setText(getInstructionAsString(this.content_numberingSystem, this));
        }else if(this.content_numberingSystem == NumberingSystem.OPCdec){
            this.contentLabel.setText(getInstructionAsString(this.content_numberingSystem, this));
        }else if(this.content_numberingSystem == NumberingSystem.DEC){
            this.contentLabel.setText(this.getIntegerValueAsString());
        }
    }

    public void showInText(){
        Instruction inst = getOpcode(this);
        System.out.println(inst);
    }
    
    public void personalizeLabel(String value){
        this.contentLabel.setText(value);
    }
    public void resetLabel(){
    
    }
    
    
    
    
    
}
