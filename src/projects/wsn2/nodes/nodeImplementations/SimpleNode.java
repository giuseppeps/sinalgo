/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects.wsn2.nodes.nodeImplementations;

import java.awt.Color;
import projects.wsn2.nodes.messages.WsnMsg;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;
import sinalgo.tools.Tools;

/**
 *
 * @author pozza
 */
public class SimpleNode extends Node {

    @Override
    public void handleMessages(Inbox inbox) {
        while (inbox.hasNext()) {
            Message message = inbox.next();
            if (message instanceof WsnMsg) {                
                WsnMsg wsnMessage = (WsnMsg) message;
                Tools.appendToOutput(this.ID+" recebeu mensagem de sink "+wsnMessage.origem+"\n");
                System.out.println(this.ID+" recebeu mensagem de sink "+wsnMessage.origem);
                WsnMsg wsnRetorno = new WsnMsg(1, this, wsnMessage.origem, this, 1);                
                this.send(wsnRetorno, wsnMessage.origem);
            }
        }    	
    }


    @Override
    public void preStep() {
    	
    	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void init() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	this.setColor(Color.GREEN);
    }

    @Override
    public void neighborhoodChange() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postStep() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkRequirements() throws WrongConfigurationException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
