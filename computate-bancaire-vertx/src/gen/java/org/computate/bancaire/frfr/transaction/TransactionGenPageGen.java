package org.computate.bancaire.frfr.transaction;

import org.computate.bancaire.frfr.transaction.TransactionBancaire;
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
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import org.computate.bancaire.frfr.cluster.ClusterPage;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionGenPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class TransactionGenPageGen<DEV> extends ClusterPage {

	//////////////////////////////
	// listeTransactionBancaire //
	//////////////////////////////

	/**	L'entité « listeTransactionBancaire »
	 *	 is defined as null before being initialized. 
	 */
	protected ListeRecherche<TransactionBancaire> listeTransactionBancaire;
	@JsonIgnore
	public Couverture<ListeRecherche<TransactionBancaire>> listeTransactionBancaireCouverture = new Couverture<ListeRecherche<TransactionBancaire>>().p(this).c(ListeRecherche.class).var("listeTransactionBancaire").o(listeTransactionBancaire);

	/**	<br/>L'entité « listeTransactionBancaire »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:listeTransactionBancaire">Trouver l'entité listeTransactionBancaire dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _listeTransactionBancaire(Couverture<ListeRecherche<TransactionBancaire>> c);

	public ListeRecherche<TransactionBancaire> getListeTransactionBancaire() {
		return listeTransactionBancaire;
	}

	public void setListeTransactionBancaire(ListeRecherche<TransactionBancaire> listeTransactionBancaire) {
		this.listeTransactionBancaire = listeTransactionBancaire;
		this.listeTransactionBancaireCouverture.dejaInitialise = true;
	}
	protected TransactionGenPage listeTransactionBancaireInit() {
		if(!listeTransactionBancaireCouverture.dejaInitialise) {
			_listeTransactionBancaire(listeTransactionBancaireCouverture);
			if(listeTransactionBancaire == null)
				setListeTransactionBancaire(listeTransactionBancaireCouverture.o);
		}
		if(listeTransactionBancaire != null)
			listeTransactionBancaire.initLoinPourClasse(requeteSite_);
		listeTransactionBancaireCouverture.dejaInitialise(true);
		return (TransactionGenPage)this;
	}

	/////////////////////////
	// transactionBancaire //
	/////////////////////////

	/**	L'entité « transactionBancaire »
	 *	 is defined as null before being initialized. 
	 */
	protected TransactionBancaire transactionBancaire;
	@JsonIgnore
	public Couverture<TransactionBancaire> transactionBancaireCouverture = new Couverture<TransactionBancaire>().p(this).c(TransactionBancaire.class).var("transactionBancaire").o(transactionBancaire);

	/**	<br/>L'entité « transactionBancaire »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionBancaire">Trouver l'entité transactionBancaire dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionBancaire(Couverture<TransactionBancaire> c);

	public TransactionBancaire getTransactionBancaire() {
		return transactionBancaire;
	}

	public void setTransactionBancaire(TransactionBancaire transactionBancaire) {
		this.transactionBancaire = transactionBancaire;
		this.transactionBancaireCouverture.dejaInitialise = true;
	}
	protected TransactionGenPage transactionBancaireInit() {
		if(!transactionBancaireCouverture.dejaInitialise) {
			_transactionBancaire(transactionBancaireCouverture);
			if(transactionBancaire == null)
				setTransactionBancaire(transactionBancaireCouverture.o);
		}
		if(transactionBancaire != null)
			transactionBancaire.initLoinPourClasse(requeteSite_);
		transactionBancaireCouverture.dejaInitialise(true);
		return (TransactionGenPage)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseTransactionGenPage = false;

	public TransactionGenPage initLoinTransactionGenPage(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseTransactionGenPage) {
			dejaInitialiseTransactionGenPage = true;
			initLoinTransactionGenPage();
		}
		return (TransactionGenPage)this;
	}

	public void initLoinTransactionGenPage() {
		super.initLoinClusterPage(requeteSite_);
		initTransactionGenPage();
	}

	public void initTransactionGenPage() {
		listeTransactionBancaireInit();
		transactionBancaireInit();
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinTransactionGenPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteTransactionGenPage(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteClusterPage(requeteSite_);
		if(listeTransactionBancaire != null)
			listeTransactionBancaire.setRequeteSite_(requeteSite_);
		if(transactionBancaire != null)
			transactionBancaire.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteTransactionGenPage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirTransactionGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirTransactionGenPage(String var) {
		TransactionGenPage oTransactionGenPage = (TransactionGenPage)this;
		switch(var) {
			case "listeTransactionBancaire":
				return oTransactionGenPage.listeTransactionBancaire;
			case "transactionBancaire":
				return oTransactionGenPage.transactionBancaire;
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
				o = attribuerTransactionGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerTransactionGenPage(String var, Object val) {
		TransactionGenPage oTransactionGenPage = (TransactionGenPage)this;
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
					o = definirTransactionGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirTransactionGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definirClusterPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsTransactionGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsTransactionGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptTransactionGenPage();
		super.htmlScript();
	}

	public void htmlScriptTransactionGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyTransactionGenPage();
		super.htmlBody();
	}

	public void htmlBodyTransactionGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlTransactionGenPage();
		super.html();
	}

	public void htmlTransactionGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaTransactionGenPage();
		super.htmlMeta();
	}

	public void htmlMetaTransactionGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesTransactionGenPage();
		super.htmlStyles();
	}

	public void htmlStylesTransactionGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleTransactionGenPage();
		super.htmlStyle();
	}

	public void htmlStyleTransactionGenPage() {
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
		if(!(o instanceof TransactionGenPage))
			return false;
		TransactionGenPage that = (TransactionGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("TransactionGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
