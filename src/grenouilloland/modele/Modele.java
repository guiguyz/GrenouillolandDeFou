
package grenouilloland.modele;



/**
 *
 * @author
 * @author
 * @version 0.1
 */
public class Modele{

    public Modele(int resolution) {

        grille = new GrilleElement(resolution);

        grenouille = new Grenouille();
    }

    public Nenuphar getNenuphar(Position position) {
        return grille.getNenuphar(position);
    }

    public synchronized void viellirNenuphar() {
        nenuphar.viellir();
    }

    /**
     * Retourne la resolution de ce plateau.
     *
     * @return la resolution de ce plateau.
     */
    public int getResolution() {
        return grille.getResolution();
    }

/*    public GrilleElement getGrille() {
        return grille;
    }

    public void setGrille(GrilleElement grille) {
        this.grille = grille;
    }*/

    public void deplacerGrenouille(Position position){
            if(position.voisine(grenouille.getPosition())){
                grenouille.setPosition(position);
                grille.lireType(position).effetSurGrenouille(grenouille);
            }

    }

    public Grenouille getGrenouille() {
        return grenouille;
    }

    public void setGrenouille(Grenouille grenouille) {
        this.grenouille = grenouille;
    }


    public void genereCheminNenuphar(){
        Position posGrenouille = grenouille.getPosition();

        for (int i = 0; i < grille.getResolution(); i++) {
            Position positionLigne = new Position(i,posGrenouille.lireColonne());
            Position positionColone = new Position(posGrenouille.lireLigne(),i);
            if (getNenuphar(positionLigne).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard(), Age.Grand);
                grille.setElement(nenuphar, positionLigne);
            }
            if (getNenuphar(positionColone).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard(), Age.Grand);
                grille.setElement(nenuphar, positionColone);
            }
        }

        for (int j = grille.getResolution()-1; j > 0; j--) {
            Position positionLigne = new Position(j,grille.getResolution()-1);
            Position positionColone = new Position(grille.getResolution()-1,j);
            if (getNenuphar(positionLigne).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard(), Age.Grand);
                grille.setElement(nenuphar, positionLigne);
            }
            if (getNenuphar(positionColone).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard(), Age.Grand);
                grille.setElement(nenuphar, positionColone);
            }
        }
    }

    /**
     * étape suivante de la grille. Fait vieillir chaque nénuphar, et
     * crée un chemin entre la position de la grenouille et la position
     * d'arrivée.
     */

    public void etapeSuivante(){

            for (int i = 0; i < grille.getResolution() - 1; i++) {
                for (int j = 0; j < grille.getResolution() - 1; j++) {
                    Position position = new Position(i, j);// le nenuphar doit avoir une position
                    nenuphar = getNenuphar(position);
                    if(nenuphar.getType()!=TypeElement.EAU || nenuphar.getType()!=TypeElement.NENUPHARIMMORTEL) {
                        nenuphar.viellir();
                        genereCheminNenuphar();
                }
            }
        }

    }

    public boolean partieFinie(){
        if(perdant()){
            System.out.println("partie finie mort");
            return true;
        }
        if(gagnant()){
            System.out.println("partie finie bonne case");
            return true;
        }
        return false;
    }

    public boolean perdant(){
        return grenouille.getPtVie()==0;
    }

    public boolean gagnant(){
        return grenouille.getPosition().lireColonne()==grille.getResolution()-1 && grenouille.getPosition().lireLigne()==grille.getResolution()-1;
    }

    //atribut
    protected GrilleElement grille;
    protected Grenouille grenouille;
    protected Nenuphar nenuphar;




}
