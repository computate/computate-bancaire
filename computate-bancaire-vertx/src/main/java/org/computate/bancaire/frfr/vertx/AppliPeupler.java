package org.computate.bancaire.frfr.vertx; 


import org.computate.bancaire.frfr.vertx.AppliPeuplerGen;
import org.computate.bancaire.frfr.config.ConfigSite;
import org.computate.bancaire.frfr.contexte.SiteContexteFrFR;
import org.computate.bancaire.frfr.couverture.Couverture;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;

/**
 * NomCanonique.enUS: org.computate.enus.academic.vertx.AppPopulate
 */
public class AppliPeupler extends AppliPeuplerGen<Object> {   

	/**
	 * Var.enUS: siteRequest_
	 */
	protected void _requeteSite_(Couverture<RequeteSiteFrFR> c) throws Exception {
	}

	/**
	 * Var.enUS: siteContext
	 */
	protected void _siteContexte(SiteContexteFrFR o) throws Exception {
	}

	/**
	 * Var.enUS: siteConfig
	 * r: siteContexte
	 * r.enUS: siteContext
	 * r: ConfigSite
	 * r.enUS: SiteConfig
	 */
	protected void _configSite(Couverture<ConfigSite> c) throws Exception {
		c.o(siteContexte.getConfigSite());
	}

	/**
	 * r: AppliPeupler
	 * r.enUS: AppPopulate
	 * r: initLoin
	 * r.enUS: initDeep
	 * r: peuplerDonnees
	 * r.enUS: populateData
	 */
	public static void main(String[] args) throws Exception {
		AppliPeupler api = new AppliPeupler();
		api.initLoinAppliPeupler();
		api.peuplerDonnees();
	}

	/**
	 * Var.enUS: populateData
	 */
	public void peuplerDonnees() throws Exception {

	}
}
