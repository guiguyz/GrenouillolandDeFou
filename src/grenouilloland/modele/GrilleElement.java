package grenouilloland.modele;




/**
 * Classe representant le jeu du GrilleElement.
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

    public Nenuphar getNenuphar(Position position) {
        return grille[position.lireLigne()][position.lireColonne()];

    }

    /**
     * Joue un nouveau coup et retourne le resultat produit.
     */
    public void jouer() {

	}

    /**
     * Indique si la position fournie en argument designe une case du plateau
     * de jeu.
     *
     * @param position la position.
     * @return true si la position designe une case du plateau de jeu sinon
     *   false.
     */
    protected boolean estValide(Position position) {
	final int ligne = position.lireLigne();
	if (ligne < 0 || ligne >= grille.length) {
	    return false;
	}
	final int colonne = position.lireColonne();
	if (colonne < 0 || colonne >= grille.length) {
	    return false;
	}
	return true;
    }

    /**
     * Indique si un pion peut etre pose sur la case dont la position en fournie
     * en argument.
     *
     * @param position la position.
     * @return true si un pion peut etre pose sur la case correspondante sinon
     *   false.
     */
    protected boolean peutPoser(Position position) {
	if (! estValide(position)) {
	    return false;
	}
	return true;
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