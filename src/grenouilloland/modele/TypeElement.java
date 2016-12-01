package grenouilloland.modele;




/**
 * Type enumere fortement type permettant une strategie d'effet sur la grenouille
 * via les differents types de nenuphars.
 *
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
public enum TypeElement{

    EAU{
        @Override
        public void effetSurGrenouille(Grenouille grenouille)
        {
			grenouille.setPtVie(-1);
			grenouille.mourir();
		}
    },

	NENUPHARIMMORTEL{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			//rien
		}
	},



    NENUPHAR{
        @Override
        public void effetSurGrenouille(Grenouille grenouille)
        {
            //rien
        }
    },

	NENUPHARVENENEUX{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			if(grenouille.estMalade())
			{
				grenouille.setPtVie(-1);
				grenouille.mourir();

			}
			else
			{
				grenouille.rendreMalade();
				if(grenouille.getPtVie()==0){
					grenouille.setPtVie(-1);
					grenouille.mourir();
				}
				else grenouille.setPtVie(grenouille.getPtVie()/2);
			}
		}
	},

	NENUPHARNUTRITIF{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			grenouille.setPtVie(grenouille.getPtVie()+1);
			grenouille.guerir();
		}
	},

	NENUPHARDOPANT{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			grenouille.setPtVie(grenouille.getPtVie()*2);
			grenouille.guerir();
		}
	},

	NENUPHARMORTEL{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			grenouille.setPtVie(-1);
            grenouille.mourir();
		}
	};

	public abstract void effetSurGrenouille(Grenouille grenouille);

	public static TypeElement auHasard(){
        int nbRand = (int)(Math.random()*(values().length-2))+2;
        return values()[nbRand];
	}



}

