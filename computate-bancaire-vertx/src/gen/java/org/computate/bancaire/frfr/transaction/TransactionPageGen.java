package org.computate.bancaire.frfr.transaction;

import org.computate.bancaire.frfr.cluster.Cluster;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;
import java.text.NumberFormat;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.computate.bancaire.frfr.couverture.Couverture;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import org.computate.bancaire.frfr.transaction.TransactionGenPage;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class TransactionPageGen<DEV> extends TransactionGenPage {

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseTransactionPage = false;

	public TransactionPage initLoinTransactionPage(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseTransactionPage) {
			dejaInitialiseTransactionPage = true;
			initLoinTransactionPage();
		}
		return (TransactionPage)this;
	}

	public void initLoinTransactionPage() {
		super.initLoinTransactionGenPage(requeteSite_);
		initTransactionPage();
	}

	public void initTransactionPage() {
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinTransactionPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteTransactionPage(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteTransactionGenPage(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteTransactionPage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirTransactionPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirTransactionPage(String var) {
		TransactionPage oTransactionPage = (TransactionPage)this;
		switch(var) {
			default:
				return super.obtenirTransactionGenPage(var);
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
				o = attribuerTransactionPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerTransactionPage(String var, Object val) {
		TransactionPage oTransactionPage = (TransactionPage)this;
		switch(var) {
			default:
				return super.attribuerTransactionGenPage(var, val);
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
					o = definirTransactionPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirTransactionPage(String var, String val) {
		switch(var) {
			default:
				return super.definirTransactionGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsTransactionPage();
		super.htmlScripts();
	}

	public void htmlScriptsTransactionPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptTransactionPage();
		super.htmlScript();
	}

	public void htmlScriptTransactionPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyTransactionPage();
		super.htmlBody();
	}

	public void htmlBodyTransactionPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlTransactionPage();
		super.html();
	}

	public void htmlTransactionPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaTransactionPage();
		super.htmlMeta();
	}

	public void htmlMetaTransactionPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesTransactionPage();
		super.htmlStyles();
	}

	public void htmlStylesTransactionPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleTransactionPage();
		super.htmlStyle();
	}

	public void htmlStyleTransactionPage() {
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
		if(!(o instanceof TransactionPage))
			return false;
		TransactionPage that = (TransactionPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("TransactionPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
