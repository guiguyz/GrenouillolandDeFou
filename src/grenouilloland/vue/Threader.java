package grenouilloland.vue;

import grenouilloland.presentateur.Presentateur;

/**
 *
 */
public class Threader extends Thread {

    public Threader(Vue vue, Presentateur presentateur){
        this.vue=vue;
        this.presentateur=presentateur;
    }

    @Override
    public void run(){
        try
        {
            while (vue.partieLancee)
            {
                // Exécution de la tâche
                presentateur.vieillirNenuphar();
                vue.mettreAJour();
                Thread.sleep (1000); // En pause pour une seconde
            }
        }
        catch (InterruptedException exception){}
    }

    protected Presentateur presentateur;

    protected Vue vue;


}