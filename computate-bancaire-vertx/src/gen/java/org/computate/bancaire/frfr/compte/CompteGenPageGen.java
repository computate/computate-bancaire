package org.computate.bancaire.frfr.compte;

import org.computate.bancaire.frfr.requete.patch.RequetePatch;
import org.computate.bancaire.frfr.cluster.Cluster;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;
import java.text.NumberFormat;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.computate.bancaire.frfr.couverture.Couverture;
import org.computate.bancaire.frfr.recherche.ListeRecherche;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;
import org.computate.bancaire.frfr.compte.CompteBancaire;
import java.util.Optional;
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import org.computate.bancaire.frfr.cluster.ClusterPage;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteGenPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class CompteGenPageGen<DEV> extends ClusterPage {

	/////////////////////////
	// listeCompteBancaire //
	/////////////////////////

	/**	L'entité « listeCompteBancaire »
	 *	 is defined as null before being initialized. 
	 */
	protected ListeRecherche<CompteBancaire> listeCompteBancaire;
	@JsonIgnore
	public Couverture<ListeRecherche<CompteBancaire>> listeCompteBancaireCouverture = new Couverture<ListeRecherche<CompteBancaire>>().p(this).c(ListeRecherche.class).var("listeCompteBancaire").o(listeCompteBancaire);

	/**	<br/>L'entité « listeCompteBancaire »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:listeCompteBancaire">Trouver l'entité listeCompteBancaire dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _listeCompteBancaire(Couverture<ListeRecherche<CompteBancaire>> c);

	public ListeRecherche<CompteBancaire> getListeCompteBancaire() {
		return listeCompteBancaire;
	}

	public void setListeCompteBancaire(ListeRecherche<CompteBancaire> listeCompteBancaire) {
		this.listeCompteBancaire = listeCompteBancaire;
		this.listeCompteBancaireCouverture.dejaInitialise = true;
	}
	protected CompteGenPage listeCompteBancaireInit() {
		if(!listeCompteBancaireCouverture.dejaInitialise) {
			_listeCompteBancaire(listeCompteBancaireCouverture);
			if(listeCompteBancaire == null)
				setListeCompteBancaire(listeCompteBancaireCouverture.o);
		}
		if(listeCompteBancaire != null)
			listeCompteBancaire.initLoinPourClasse(requeteSite_);
		listeCompteBancaireCouverture.dejaInitialise(true);
		return (CompteGenPage)this;
	}

	////////////////////
	// compteBancaire //
	////////////////////

	/**	L'entité « compteBancaire »
	 *	 is defined as null before being initialized. 
	 */
	protected CompteBancaire compteBancaire;
	@JsonIgnore
	public Couverture<CompteBancaire> compteBancaireCouverture = new Couverture<CompteBancaire>().p(this).c(CompteBancaire.class).var("compteBancaire").o(compteBancaire);

	/**	<br/>L'entité « compteBancaire »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteBancaire">Trouver l'entité compteBancaire dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compteBancaire(Couverture<CompteBancaire> c);

	public CompteBancaire getCompteBancaire() {
		return compteBancaire;
	}

	public void setCompteBancaire(CompteBancaire compteBancaire) {
		this.compteBancaire = compteBancaire;
		this.compteBancaireCouverture.dejaInitialise = true;
	}
	protected CompteGenPage compteBancaireInit() {
		if(!compteBancaireCouverture.dejaInitialise) {
			_compteBancaire(compteBancaireCouverture);
			if(compteBancaire == null)
				setCompteBancaire(compteBancaireCouverture.o);
		}
		if(compteBancaire != null)
			compteBancaire.initLoinPourClasse(requeteSite_);
		compteBancaireCouverture.dejaInitialise(true);
		return (CompteGenPage)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseCompteGenPage = false;

	public CompteGenPage initLoinCompteGenPage(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseCompteGenPage) {
			dejaInitialiseCompteGenPage = true;
			initLoinCompteGenPage();
		}
		return (CompteGenPage)this;
	}

	public void initLoinCompteGenPage() {
		initCompteGenPage();
		super.initLoinClusterPage(requeteSite_);
	}

	public void initCompteGenPage() {
		listeCompteBancaireInit();
		compteBancaireInit();
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinCompteGenPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCompteGenPage(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteClusterPage(requeteSite_);
		if(listeCompteBancaire != null)
			listeCompteBancaire.setRequeteSite_(requeteSite_);
		if(compteBancaire != null)
			compteBancaire.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteCompteGenPage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCompteGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCompteGenPage(String var) {
		CompteGenPage oCompteGenPage = (CompteGenPage)this;
		switch(var) {
			case "listeCompteBancaire":
				return oCompteGenPage.listeCompteBancaire;
			case "compteBancaire":
				return oCompteGenPage.compteBancaire;
			default:
				return super.obtenirClusterPage(var);
		}
	}

	///////////////
	// attribuer //
	///////////////

	@Override public boolean attribuerPourClasse(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerCompteGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCompteGenPage(String var, Object val) {
		CompteGenPage oCompteGenPage = (CompteGenPage)this;
		switch(var) {
			default:
				return super.attribuerClusterPage(var, val);
		}
	}

	/////////////
	// definir //
	/////////////

	@Override public boolean definirPourClasse(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirCompteGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCompteGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definirClusterPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsCompteGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsCompteGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptCompteGenPage();
		super.htmlScript();
	}

	public void htmlScriptCompteGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyCompteGenPage();
		super.htmlBody();
	}

	public void htmlBodyCompteGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlCompteGenPage();
		super.html();
	}

	public void htmlCompteGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaCompteGenPage();
		super.htmlMeta();
	}

	public void htmlMetaCompteGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesCompteGenPage();
		super.htmlStyles();
	}

	public void htmlStylesCompteGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleCompteGenPage();
		super.htmlStyle();
	}

	public void htmlStyleCompteGenPage() {
	}

	//////////////////
	// requetePatch //
	//////////////////

	public void requetePatchCompteGenPage() {
		RequetePatch requetePatch = Optional.ofNullable(requeteSite_).map(RequeteSiteFrFR::getRequetePatch_).orElse(null);
		CompteGenPage original = (CompteGenPage)Optional.ofNullable(requetePatch).map(RequetePatch::getOriginal).orElse(null);
		if(original != null) {
			super.requetePatchClusterPage();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof CompteGenPage))
			return false;
		CompteGenPage that = (CompteGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("CompteGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
