package org.computate.bancaire.frfr.page.part;    


import org.computate.bancaire.frfr.cluster.Cluster;
import org.computate.bancaire.frfr.couverture.Couverture;
import org.computate.bancaire.frfr.page.MiseEnPage;


/**
 * NomCanonique.enUS: org.computate.bancaire.enus.page.part.PagePart
 * MotCle: classeNomSimplePagePart
 */ 
public abstract class PagePart extends PagePartGen<Cluster> { 

	protected void _page_(Couverture<MiseEnPage> c) {}

	public void  htmlBody() {
		
	}

	/**
	 * Var.enUS: htmlBodyShort
	 */
	public void  htmlBodyCourt() {
		
	}

	protected void _partVar(Couverture<String> c) {}

	/**
	 * Var.enUS: htmlBeforePagePart
	 */
	public void  htmlAvantPagePart() {}

	/**
	 * Var.enUS: htmlAfterPagePart
	 */
	public void  htmlApresPagePart() {}
}
