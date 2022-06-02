/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects.wsn2.nodes.nodeImplementations;

import java.awt.Color;

/**
 *
 * @author pozza
 */
import projects.wsn2.nodes.messages.WsnMsg;
import projects.wsn2.nodes.timers.WsnMessageTimer;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;
import sinalgo.tools.Tools;

/**
 *
 * @author pozza
 */
public class SinkNode extends Node {       

    @Override
    public void handleMessages(Inbox inbox) {
        while (inbox.hasNext()) {
            Message message = inbox.next();
            if (message instanceof WsnMsg) {
                WsnMsg wsnMessage = (WsnMsg) message; 
                if (wsnMessage.tipoMsg == 1){
                	Tools.appendToOutput("Sink recebe mensagem "+wsnMessage.sequenceID+" de "+wsnMessage.origem+"\n");
                    System.out.println("Sink recebe mensagem "+wsnMessage.sequenceID+" de "+wsnMessage.origem);
                }                
            }
        }
    }

    @Override
    public void preStep() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Node.NodePopupMethod(menuText = "Enviar mensagem em broadcast")
    public void construirRoteamento() {        
        WsnMsg wsnMessage = new WsnMsg(1, this, null, this, 0);
        WsnMessageTimer timer = new WsnMessageTimer(wsnMessage);
        timer.startRelative(1, this);
        Tools.appendToOutput("Enviou mensagem em broadcast\n");
        System.out.println("Enviou mensagem!");
    }

    @Override
    public void init() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	this.setColor(Color.BLUE);
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
