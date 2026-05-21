package example;

// Environment code for project almoxarifado

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;

import java.text.ParseException;
import java.util.Random;

import java.util.logging.*;

public class Env extends Environment {

    private Logger logger = Logger.getLogger("almoxarifado."+Env.class.getName());
    String peca;

    String sorteiaPeca(){
        Random gerador = new Random();
        String resposta="";
        switch (gerador.nextInt(3)) {
            case 0:
                resposta = "peca(peq)";
                break;
            case 1:
                resposta = "peca(med)";
                break;
            case 2:
                resposta = "peca(grd)";
                break;
            default:
                break;
        }
        return resposta;
    }


    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
        try {
            peca = "peca(peq)";
            addPercept(ASSyntax.parseLiteral(peca));
            logger.info("Entrou a " + peca);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        //logger.info(agName + "esta solicitando a ação "+action.getFunctor().toString() + " peça "+ action.getTerm(0).toString());
        if (agName.equals("r1") && action.getFunctor().equals("guardar") && action.getTerm(0).equals("peq"))  { // you may improve this condition
            // chamada a um atuador
            logger.info(agName + "guardando peça "+ action.getTerm(0).toString());
            removePercept(ASSyntax.parseLiteral(action.toString()));    
        } else logger.info("executing: "+action+", but not implemented!");
        
        
        return true; // the action was executed with success
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
}
