package org.computate.bancaire.frfr.ajustement;

import org.computate.bancaire.frfr.cluster.Cluster;
import java.math.MathContext;
import org.computate.bancaire.frfr.ajustement.AjustementBancaire;
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
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import org.computate.bancaire.frfr.cluster.ClusterPage;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementGenPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class AjustementGenPageGen<DEV> extends ClusterPage {

	/////////////////////////////
	// listeAjustementBancaire //
	/////////////////////////////

	/**	L'entité « listeAjustementBancaire »
	 *	 is defined as null before being initialized. 
	 */
	protected ListeRecherche<AjustementBancaire> listeAjustementBancaire;
	@JsonIgnore
	public Couverture<ListeRecherche<AjustementBancaire>> listeAjustementBancaireCouverture = new Couverture<ListeRecherche<AjustementBancaire>>().p(this).c(ListeRecherche.class).var("listeAjustementBancaire").o(listeAjustementBancaire);

	/**	<br/>L'entité « listeAjustementBancaire »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:listeAjustementBancaire">Trouver l'entité listeAjustementBancaire dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _listeAjustementBancaire(Couverture<ListeRecherche<AjustementBancaire>> c);

	public ListeRecherche<AjustementBancaire> getListeAjustementBancaire() {
		return listeAjustementBancaire;
	}

	public void setListeAjustementBancaire(ListeRecherche<AjustementBancaire> listeAjustementBancaire) {
		this.listeAjustementBancaire = listeAjustementBancaire;
		this.listeAjustementBancaireCouverture.dejaInitialise = true;
	}
	protected AjustementGenPage listeAjustementBancaireInit() {
		if(!listeAjustementBancaireCouverture.dejaInitialise) {
			_listeAjustementBancaire(listeAjustementBancaireCouverture);
			if(listeAjustementBancaire == null)
				setListeAjustementBancaire(listeAjustementBancaireCouverture.o);
		}
		if(listeAjustementBancaire != null)
			listeAjustementBancaire.initLoinPourClasse(requeteSite_);
		listeAjustementBancaireCouverture.dejaInitialise(true);
		return (AjustementGenPage)this;
	}

	////////////////////////
	// ajustementBancaire //
	////////////////////////

	/**	L'entité « ajustementBancaire »
	 *	 is defined as null before being initialized. 
	 */
	protected AjustementBancaire ajustementBancaire;
	@JsonIgnore
	public Couverture<AjustementBancaire> ajustementBancaireCouverture = new Couverture<AjustementBancaire>().p(this).c(AjustementBancaire.class).var("ajustementBancaire").o(ajustementBancaire);

	/**	<br/>L'entité « ajustementBancaire »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:ajustementBancaire">Trouver l'entité ajustementBancaire dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _ajustementBancaire(Couverture<AjustementBancaire> c);

	public AjustementBancaire getAjustementBancaire() {
		return ajustementBancaire;
	}

	public void setAjustementBancaire(AjustementBancaire ajustementBancaire) {
		this.ajustementBancaire = ajustementBancaire;
		this.ajustementBancaireCouverture.dejaInitialise = true;
	}
	protected AjustementGenPage ajustementBancaireInit() {
		if(!ajustementBancaireCouverture.dejaInitialise) {
			_ajustementBancaire(ajustementBancaireCouverture);
			if(ajustementBancaire == null)
				setAjustementBancaire(ajustementBancaireCouverture.o);
		}
		if(ajustementBancaire != null)
			ajustementBancaire.initLoinPourClasse(requeteSite_);
		ajustementBancaireCouverture.dejaInitialise(true);
		return (AjustementGenPage)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseAjustementGenPage = false;

	public AjustementGenPage initLoinAjustementGenPage(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseAjustementGenPage) {
			dejaInitialiseAjustementGenPage = true;
			initLoinAjustementGenPage();
		}
		return (AjustementGenPage)this;
	}

	public void initLoinAjustementGenPage() {
		super.initLoinClusterPage(requeteSite_);
		initAjustementGenPage();
	}

	public void initAjustementGenPage() {
		listeAjustementBancaireInit();
		ajustementBancaireInit();
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinAjustementGenPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteAjustementGenPage(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteClusterPage(requeteSite_);
		if(listeAjustementBancaire != null)
			listeAjustementBancaire.setRequeteSite_(requeteSite_);
		if(ajustementBancaire != null)
			ajustementBancaire.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteAjustementGenPage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirAjustementGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirAjustementGenPage(String var) {
		AjustementGenPage oAjustementGenPage = (AjustementGenPage)this;
		switch(var) {
			case "listeAjustementBancaire":
				return oAjustementGenPage.listeAjustementBancaire;
			case "ajustementBancaire":
				return oAjustementGenPage.ajustementBancaire;
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
				o = attribuerAjustementGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerAjustementGenPage(String var, Object val) {
		AjustementGenPage oAjustementGenPage = (AjustementGenPage)this;
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
					o = definirAjustementGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirAjustementGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definirClusterPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsAjustementGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsAjustementGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptAjustementGenPage();
		super.htmlScript();
	}

	public void htmlScriptAjustementGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyAjustementGenPage();
		super.htmlBody();
	}

	public void htmlBodyAjustementGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlAjustementGenPage();
		super.html();
	}

	public void htmlAjustementGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaAjustementGenPage();
		super.htmlMeta();
	}

	public void htmlMetaAjustementGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesAjustementGenPage();
		super.htmlStyles();
	}

	public void htmlStylesAjustementGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleAjustementGenPage();
		super.htmlStyle();
	}

	public void htmlStyleAjustementGenPage() {
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
		if(!(o instanceof AjustementGenPage))
			return false;
		AjustementGenPage that = (AjustementGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("AjustementGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
