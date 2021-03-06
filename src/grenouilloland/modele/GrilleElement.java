package grenouilloland.modele;




/**
 * Classe representant le jeu du GrilleElement.
 *
 * @author Alexis Prevost Maynen
 * @author Guillaume Drouart
 * @author Lucas Gouedard
 * @author Nicolas Vatel
 */
public class GrilleElement {

    /**
     * Constructeur logique.
     *
     * @param resolution la resolution du plateau de jeu.
     */
    public GrilleElement(int resolution) {
		grille = new Nenuphar[resolution][resolution];
		for (int i = 0; i < resolution; i ++) {
			for (int j = 0; j < resolution; j ++) {
				grille[i][j] = new Nenuphar();
			}
		}
		grille[0][0].setType(TypeElement.NENUPHARIMMORTEL);
        grille[resolution-1][resolution-1].setType(TypeElement.NENUPHARIMMORTEL);
    }


    /**
     * Retourne la resolution de ce plateau.
     *
     * @return la resolution de ce plateau.
     */
    public int getResolution() {
	return grille.length;
    }

    /**
     * Retourne le contenu de la case dont la position est fournie en argument.
     *
     * @param position la position.
     * @return le contenu de la case correspondante.
     */
    public TypeElement lireType(Position position) {
	    return grille[position.lireLigne()][position.lireColonne()].getType();
    }


    /**
     * Retourne la position d'un nenuphar.
     *
     * @param position la position.
     * @return le contenu de la case correspondante.
     */
    public Nenuphar getNenuphar(Position position) {
        return grille[position.lireLigne()][position.lireColonne()];

    }



    /**
     * Depose un pion sur la case dont la position est fournie en argument.
     *
     * @param nenuphar le nenuphar.
     * @param position la position.
     */
    protected void setElement(Nenuphar nenuphar, Position position) {
        grille[position.lireLigne()][position.lireColonne()] = nenuphar;
    }

    /**
     * Grille de nenuphar.
     */
    protected Nenuphar[][] grille;

}