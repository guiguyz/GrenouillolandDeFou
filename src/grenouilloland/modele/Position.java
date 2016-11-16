package grenouilloland.modele;

/**
 * Classe representant une position dans un repere cartesien
 */
public class Position {

    /**
     * Constructeur logique.
     *
     * @param ligne la valeur de {@link Position#ligne}.
     * @param colonne la valeur de {@link Position#colonne}.
     */
    public Position(int ligne, int colonne) {
	this.ligne = ligne;
	this.colonne = colonne;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Position#ligne}.
     */
    public int lireLigne() {
	return ligne;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Position#colonne}.
     */
    public int lireColonne() {
	return colonne;
    }

    /**
     * Retourne la voisine de cette position selon la direction fournie en
     * argument.
     *
     * @param direction la direction.
     * @return la voisine de cette position selon la direction fournie en
     *   argument.
     */
    public Position voisine(Direction direction) {
	return new Position(ligne + direction.lireDeltaLigne(),
			    colonne + direction.lireDeltaColonne());
    }

    /**
     * Numero de ligne.
     */
    protected final int ligne;

    /**
     * Numero de colonne.
     */
    protected final int colonne;

}